package com.daxiong.moivebaselib.http;

import android.content.Context;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/7
 */
public class RetofitManager {
    private static final int DEFAULT_TIME_OUT = 10;
    private static final String TAG = "RetofitManager";
    private Retrofit retrofit;
    private MoiveService moiveService;
    private static class SingletonInstance{
        private static final RetofitManager INSTANCE = new RetofitManager();
    }

    public RetofitManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);


        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(TAG, "message:" + message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constant.DOUBAN_BASE_URL)
                .build();
        moiveService = retrofit.create(MoiveService.class);
    }

    public static RetofitManager getInstance(){
        return SingletonInstance.INSTANCE;
    }

    public MoiveService getMoiveService(){
        return  moiveService;
    }

}
