package org.xiangbalao.tinkerdemo.app;

import android.app.Application;


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
    }



}



