package com.example.user.qrrecoder.app;

import android.app.Application;
import android.content.Context;

import com.example.user.qrrecoder.data.greendaoutil.DBUtils;
import com.example.user.qrrecoder.data.greendaoutil.GreenDaoUtils;

/**
 * Created by USER on 2017/11/7.
 */

public class MyApp extends Application {
    public static Context app;
    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        GreenDaoUtils.init(this);
    }
}
