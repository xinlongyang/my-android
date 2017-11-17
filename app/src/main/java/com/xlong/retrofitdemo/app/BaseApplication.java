package com.xlong.retrofitdemo.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * 自定义应用入口
 *
 * @author Hunter
 */
public class BaseApplication extends Application {
    private static BaseApplication mInstance;

    public static Context getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


}
