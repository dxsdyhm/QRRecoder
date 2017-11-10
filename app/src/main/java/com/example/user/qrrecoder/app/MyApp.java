package com.example.user.qrrecoder.app;

import android.app.Application;

import com.example.user.qrrecoder.data.greendaoutil.DBUtils;
import com.example.user.qrrecoder.data.greendaoutil.GreenDaoUtils;

/**
 * Created by USER on 2017/11/7.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GreenDaoUtils.init(this);
    }
}
