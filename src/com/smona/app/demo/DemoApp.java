package com.smona.app.demo;

import com.smona.app.demo.common.image.ImageLoaderManager;

import android.app.Application;

public class DemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderManager.getInstance().initImageLoader(this);
    }

}
