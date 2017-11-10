package com.example.user.qrrecoder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.widget.Button;

import com.example.user.qrrecoder.R;
import com.example.user.qrrecoder.base.BaseFullScreenActivity;
import com.example.user.qrrecoder.data.greendao.User;
import com.example.user.qrrecoder.eventbus.eventbusaction.UserAction;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by USER on 2017/11/7.
 */

public class LoginActivity extends BaseFullScreenActivity {
    @BindView(R.id.bt_go)
    Button btGo;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.cv)
    CardView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.bt_go)
    public void onViewClicked() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        EventBus.getDefault().postSticky(new UserAction(new User("1","dxsdyhm","dxs19911225")));
    }
}
