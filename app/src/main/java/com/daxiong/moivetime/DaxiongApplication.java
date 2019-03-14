package com.daxiong.moivetime;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/13
 */
public class DaxiongApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        Fresco.initialize(this);
    }
}
