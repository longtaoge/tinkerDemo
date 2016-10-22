package org.xiangbalao.tinkerdemo.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

import org.xiangbalao.tinkerdemo.tinker.Log.MyLogImp;
import org.xiangbalao.tinkerdemo.tinker.utils.SampleApplicationContext;
import org.xiangbalao.tinkerdemo.tinker.utils.TinkerManager;

/**
 * Created by longtaoge on 16/10/21.
 */


@DefaultLifeCycle(application = "org.xiangbalao.tinkerdemo.app.MyApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class ApplicationLike extends DefaultApplicationLike {

    public ApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent, Resources[] resources, ClassLoader[] classLoader, AssetManager[] assetManager) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent, resources, classLoader, assetManager);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);

        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        SampleApplicationContext.application = getApplication();
        SampleApplicationContext.context = getApplication().getApplicationContext();
        TinkerManager.setTinkerApplicationLike(this);
        TinkerManager.initFastCrashProtect();
        //should set before tinker is installed
        TinkerManager.setUpgradeRetryEnable(true);

        //optional set logIml, or you can use default debug log
        TinkerInstaller.setLogIml(new MyLogImp());

        //installTinker after load multiDex
        //or you can put com.tencent.tinker.** to main dex
        TinkerManager.installTinker(this);


    }






    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        getApplication().registerActivityLifecycleCallbacks(callback);
    }
}
