package org.xiangbalao.tinkerdemo.app;

import android.app.Application;
import android.widget.Toast;

import com.taobao.hotfix.HotFixManager;
import com.taobao.hotfix.PatchLoadStatusListener;
import com.taobao.hotfix.util.PatchStatusCode;


/**
 * Created by longtaoge on 16/10/21.
 */


public class ApplicationLike extends Application {

    public static String appVersion;
    public static String appId;


    @Override
    public void onCreate() {
        super.onCreate();
        initApp();

    }

    private void initApp() {


        this.appId = "83914-1"; //替换掉自己应用的appId  83914-1    69921-1
        try {
            this.appVersion = this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName;
        } catch (Exception e) {
            this.appVersion = "1.0.0";
        }


        HotFixManager.getInstance()
                .setContext(this)
                .setAppVersion(ApplicationLike.appVersion)
                .setAppId(ApplicationLike.appId)
                .setAesKey(null)
                .setSupportHotpatch(true)
                .setEnableDebug(true)
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onload(final int mode, final int code, final String info, final int handlePatchVersion) {
                        // 补丁加载回调通知
                        if (code == PatchStatusCode.CODE_SUCCESS_LOAD) {
                            // TODO: 10/24/16 表明补丁加载成功


                        } else if (code == PatchStatusCode.CODE_ERROR_NEEDRESTART) {
                            // TODO: 10/24/16 表明新补丁生效需要重启. 业务方可自行实现逻辑, 提示用户或者强制重启, 建议: 用户可以监听进入后台事件, 然后应用自杀
                        } else if (code == PatchStatusCode.CODE_ERROR_INNERENGINEFAIL) {
                            // 内部引擎加载异常, 推荐此时清空本地补丁, 但是不清空本地版本号, 防止失败补丁重复加载
                            HotFixManager.getInstance().cleanPatches(false);
                        } else {
                            // TODO: 10/25/16 其它错误信息, 查看PatchStatusCode类说明
                        }

                        Toast.makeText(getApplicationContext(), info, Toast.LENGTH_LONG).show();


                    }
                }).initialize();
    }


}



