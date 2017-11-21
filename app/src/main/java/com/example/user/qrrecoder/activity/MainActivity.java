package com.example.user.qrrecoder.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.qrrecoder.R;
import com.example.user.qrrecoder.base.BaseActivity;
import com.example.user.qrrecoder.data.greendao.User;
import com.example.user.qrrecoder.eventbus.eventbusaction.UserAction;
import com.hdl.elog.ELog;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tx_userinfo)
    TextView txUserinfo;
    @BindView(R.id.btn_scan)
    Button btnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Subscribe(sticky = true)
    public void onUserLoginSuccess(UserAction userAction) {
        User user = userAction.getUser();
        StringBuilder sb=new StringBuilder();
        sb.append("编号："+user.getUserid());
        sb.append("\n");
        sb.append("姓名："+user.getUsername());
        sb.append("\n");
        sb.append("密码："+user.getUserpwd());
        sb.append("\n");
        txUserinfo.setText(sb.toString());
    }

    @OnClick(R.id.btn_scan)
    public void onViewClicked() {
        RequirePermission();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void RequirePermission(){
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.CAMERA)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        ELog.dxs("aBoolean:"+aBoolean);
                        Intent scan=new Intent(MainActivity.this,ZbarActivity.class);
                        startActivity(scan);
                    }
                });
    }
}
