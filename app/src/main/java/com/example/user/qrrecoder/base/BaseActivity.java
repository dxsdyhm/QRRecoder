package com.example.user.qrrecoder.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gyf.barlibrary.ImmersionBar;
import com.hdl.elog.ELog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by USER on 2017/11/7.
 */

public abstract class BaseActivity extends BaseCoreActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!initBar()){
            //ImmersionBar.with(this).init();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!destroyBar()){
            //ImmersionBar.with(this).destroy();
        }
    }
    
    @Override
    public boolean initBar() {
        return false;
    }

    @Override
    public boolean destroyBar() {
        return false;
    }
}
