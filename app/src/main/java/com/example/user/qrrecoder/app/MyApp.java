package com.example.user.qrrecoder.app;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.user.qrrecoder.data.greendao.User;
import com.example.user.qrrecoder.data.greendaoauto.UserDao;
import com.example.user.qrrecoder.data.greendaoutil.DBUtils;
import com.example.user.qrrecoder.data.greendaoutil.GreenDaoUtils;
import com.example.user.qrrecoder.utils.SharedPrefreUtils;

import org.greenrobot.greendao.query.QueryBuilder;

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

    public static User getActiveUser(){
        String account= SharedPrefreUtils.getInstance().getStringData(app,SPKey.SP_ACTIVEUSER);
        Log.e("dxsTest","username:"+account);
        if(TextUtils.isEmpty(account)){
            return null;
        }
        QueryBuilder<User> builder=DBUtils.getUserService().queryBuilder();
        builder.where(UserDao.Properties.Acount.eq(account));
        return builder.unique();
    }
}
