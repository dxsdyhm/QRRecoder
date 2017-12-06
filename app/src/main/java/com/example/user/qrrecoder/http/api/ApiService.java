package com.example.user.qrrecoder.http.api;

import com.example.user.qrrecoder.http.Enty.HttpResult;
import com.example.user.qrrecoder.http.Enty.HttpResults;
import com.example.user.qrrecoder.http.Enty.LoginResult;
import com.example.user.qrrecoder.http.Enty.Subject;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by USER on 2017/11/16.
 */

public interface ApiService {
    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);

    @POST("login")
    Observable<HttpResults<LoginResult>> login(@Query("account") String start, @Query("pwd") String pwd);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("scanrecord")
    Observable<HttpResults> uploadRecord(@Query("account") String account,@Query("sessionid") int sessionid,@Body RequestBody route);

    @GET("logout")
    Observable<HttpResults> logout();

}
