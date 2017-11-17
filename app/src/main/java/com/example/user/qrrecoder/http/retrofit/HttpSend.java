package com.example.user.qrrecoder.http.retrofit;

import android.content.Intent;
import android.util.Log;

import com.example.user.qrrecoder.activity.LoginActivity;
import com.example.user.qrrecoder.activity.MainActivity;
import com.example.user.qrrecoder.data.greendao.User;
import com.example.user.qrrecoder.eventbus.eventbusaction.UserAction;
import com.example.user.qrrecoder.http.Enty.HttpResult;
import com.example.user.qrrecoder.http.Enty.HttpResults;
import com.example.user.qrrecoder.http.Enty.Subject;
import com.example.user.qrrecoder.http.api.ApiService;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dxs on 2017/11/17.
 */

public class HttpSend {
    private static class HtpSendHolder{
        public static final HttpSend INSTENCE=new HttpSend();
    }
    private HttpSend (){

    }

    public static HttpSend getInstence(){
        return HtpSendHolder.INSTENCE;
    }

    public void login(String userName,String userPwd,Observer<HttpResults<List<Subject>>> observer){
        String baseUrl = "https://api.douban.com/v2/movie/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiService movieService = retrofit.create(ApiService.class);

        movieService.getTopMovie(0, 10)
                .map(new HttpResultFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
