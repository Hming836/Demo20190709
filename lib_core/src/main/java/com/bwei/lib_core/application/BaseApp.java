package com.bwei.lib_core.application;

import android.app.Application;
import android.content.Context;

/**
 * @Auther :Hming
 * @Date : 2019/7/9  20:23
 * @Description: ${DESCRIPTION}
 */
public class BaseApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;

    }
}
