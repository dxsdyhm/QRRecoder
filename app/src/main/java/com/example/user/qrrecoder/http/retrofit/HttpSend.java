package com.example.user.qrrecoder.http.retrofit;

import android.content.Intent;
import android.util.Log;

import com.example.user.qrrecoder.activity.LoginActivity;
import com.example.user.qrrecoder.activity.MainActivity;
import com.example.user.qrrecoder.app.MyApp;
import com.example.user.qrrecoder.data.greendao.DeviceItem;
import com.example.user.qrrecoder.data.greendao.User;
import com.example.user.qrrecoder.entity.UploadRecords;
import com.example.user.qrrecoder.eventbus.eventbusaction.UserAction;
import com.example.user.qrrecoder.http.Enty.HttpResult;
import com.example.user.qrrecoder.http.Enty.HttpResults;
import com.example.user.qrrecoder.http.Enty.LoginResult;
import com.example.user.qrrecoder.http.Enty.Subject;
import com.example.user.qrrecoder.http.api.ApiService;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import org.greenrobot.eventbus.EventBus;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dxs on 2017/11/17.
 */

public class HttpSend {
    private final static String BASEURL="http://192.168.1.80:8080/psp/ja/v1/";
    private static class HtpSendHolder{
        public static final HttpSend INSTENCE=new HttpSend();
    }
    private HttpSend (){

    }

    public static HttpSend getInstence(){
        return HtpSendHolder.INSTENCE;
    }
    ClearableCookieJar cookieJar;
    public void login(String userName,String userPwd,Observer<LoginResult> observer){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // Log信息拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//这里可以选择拦截级别
        //设置 Debug Log 模式
        // init cookie manager
        if(cookieJar==null){
            cookieJar =
                    new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(MyApp.app));
        }
        builder.addInterceptor(loggingInterceptor)
                .cookieJar(cookieJar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

        ApiService movieService = retrofit.create(ApiService.class);

        movieService.login(userName, userPwd)
                .map(new HttpResultFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void uploadRecord(UploadRecords records, Observer<String> observer){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // Log信息拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//这里可以选择拦截级别
        //设置 Debug Log 模式
        // init cookie manager
        if(cookieJar==null){
            cookieJar =
                    new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(MyApp.app));
        }
        builder.addInterceptor(loggingInterceptor)
                .cookieJar(cookieJar);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        //"application/json; charset=utf-8"
        RequestBody body=
                RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), records.getJsonString());
        ApiService uploadRecord = retrofit.create(ApiService.class);
        uploadRecord.uploadRecord(records.getUserId(),records.getSessionid(), body)
                .map(new HttpResultFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void logout(Observer<HttpResults> observer){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // Log信息拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//这里可以选择拦截级别
        //设置 Debug Log 模式
        // init cookie manager
        if(cookieJar==null){
            cookieJar =
                    new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(MyApp.app));
        }
        builder.addInterceptor(loggingInterceptor)
                .cookieJar(cookieJar);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

        ApiService uploadRecord = retrofit.create(ApiService.class);
        uploadRecord.logout()
                .map(new HttpResultFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
