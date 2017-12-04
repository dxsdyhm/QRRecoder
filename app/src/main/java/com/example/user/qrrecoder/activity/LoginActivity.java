package com.example.user.qrrecoder.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.user.qrrecoder.R;
import com.example.user.qrrecoder.app.SPKey;
import com.example.user.qrrecoder.base.BaseFullScreenActivity;
import com.example.user.qrrecoder.data.greendao.User;
import com.example.user.qrrecoder.eventbus.eventbusaction.UserAction;
import com.example.user.qrrecoder.http.Enty.HttpResult;
import com.example.user.qrrecoder.http.Enty.HttpResults;
import com.example.user.qrrecoder.http.Enty.LoginResult;
import com.example.user.qrrecoder.http.Enty.Subject;
import com.example.user.qrrecoder.http.api.ApiService;
import com.example.user.qrrecoder.http.retrofit.HttpSend;
import com.example.user.qrrecoder.utils.SharedPrefreUtils;
import com.hdl.elog.ELog;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mContext=this;
    }

    @OnClick(R.id.bt_go)
    public void onViewClicked() {
        createDialog();
        Login();
    }

    private MaterialDialog.Builder builder;
    private void createDialog(){
        builder = new MaterialDialog.Builder(this)
                .title(R.string.app_name)
                .content(R.string.logining)
                .progress(true,0);
    }

    private void Login() {
        final MaterialDialog dialog = builder.build();

        HttpSend.getInstence().login("dxs@gwell.cc", "test", new Observer<LoginResult>() {
            @Override
            public void onSubscribe(Disposable d) {
                dialog.show();
            }


            @Override
            public void onNext(LoginResult loginResult) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                User user=new User();
                user.setUserid(loginResult.getFidentity());
                user.setFname(loginResult.getFname());
                user.setUsername(loginResult.getFusername());
                user.setEmail(loginResult.getFmail());
                SharedPrefreUtils.getInstance().putStringData(mContext, SPKey.SP_ACTIVEUSER,user.getFname());
                EventBus.getDefault().postSticky(new UserAction(user));
                finish();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("dxsTest","Throwable"+e);
                dialog.dismiss();
            }

            @Override
            public void onComplete() {
                Log.e("dxsTest","onComplete");
                dialog.dismiss();
            }
        });
    }
}
