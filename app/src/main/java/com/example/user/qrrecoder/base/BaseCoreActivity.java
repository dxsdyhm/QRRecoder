package com.example.user.qrrecoder.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by USER on 2017/11/8.
 */

public abstract class BaseCoreActivity extends AppCompatActivity {
    public abstract boolean initBar();
    public abstract boolean destroyBar();
}
