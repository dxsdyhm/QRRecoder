package com.example.user.qrrecoder.http.api;

import com.example.user.qrrecoder.http.Enty.HttpResult;
import com.example.user.qrrecoder.http.Enty.Subject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by USER on 2017/11/16.
 */

public interface ApiService {
    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);
}
