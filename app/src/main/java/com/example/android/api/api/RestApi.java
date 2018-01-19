package com.example.android.api.api;

import com.example.android.api.BuildConfig;
import com.example.android.api.interceptor.LoggingInterceptor;
import com.example.android.api.model.BookModel;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pc on 1/19/2018.
 */

public class RestApi {
    public static final int request_max_time_in_seconds = 20;

    public Retrofit getRetrofitInstance(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .readTimeout(request_max_time_in_seconds, TimeUnit.SECONDS)
                .connectTimeout(request_max_time_in_seconds, TimeUnit.SECONDS)
                .build();
        return new  Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
    public ApiService request(){
        return getRetrofitInstance().create(ApiService.class);
    }
    public Call<BookModel> getPhotos (String id){
        return request().getBooks(id);
    }
}

