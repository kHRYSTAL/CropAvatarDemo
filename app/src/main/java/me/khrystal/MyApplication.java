package me.khrystal;

import android.app.Application;

/**
 * Created by ASUS on 2015/12/3.
 */
public class MyApplication extends Application{
    private static MyApplication sInstance;

    public static MyApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
