package com.example.user.qrrecoder.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.user.qrrecoder.R;
import com.example.user.qrrecoder.base.BaseActivity;
import com.example.user.qrrecoder.data.greendao.User;
import com.example.user.qrrecoder.eventbus.eventbusaction.UserAction;
import com.example.user.qrrecoder.http.Enty.LoginResult;
import com.example.user.qrrecoder.http.retrofit.HttpSend;
import com.example.user.qrrecoder.utils.SizeUtils;
import com.hdl.elog.ELog;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tx_userinfo)
    TextView txUserinfo;
    @BindView(R.id.btn_scan)
    Button btnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected int getConstomLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setToolBarNavigation() {
        //不需要返回箭头
        toolbar.setContentInsetsAbsolute(SizeUtils.dp2px(TOOLBAR_MARGING),0);
    }

    @Subscribe(sticky = true)
    public void onUserLoginSuccess(UserAction userAction) {
        User user = userAction.getUser();
        StringBuilder sb=new StringBuilder();
        sb.append("编号："+user.getUserid());
        sb.append("\n");
        sb.append("姓名："+user.getUsername());
        sb.append("\n");
        sb.append("邮箱："+user.getEmail());
        sb.append("\n");
        sb.append("公司："+user.getFname());
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
//                        Login();
                    }
                });
    }

    private void Login() {

        HttpSend.getInstence().login("dxs@gwell.cc", "test", new Observer<LoginResult>() {
            @Override
            public void onSubscribe(Disposable d) {

            }


            @Override
            public void onNext(LoginResult loginResult) {
               Log.e("dxsTest","loginResult:"+loginResult.getFname());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("dxsTest","Throwable"+e);
            }

            @Override
            public void onComplete() {
                Log.e("dxsTest","onComplete");
            }
        });
    }
}
