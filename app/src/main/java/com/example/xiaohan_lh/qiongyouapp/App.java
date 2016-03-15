package com.example.xiaohan_lh.qiongyouapp;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;

/**
 * Created by xiaohan-lh on 16/3/14.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);


    }
}
