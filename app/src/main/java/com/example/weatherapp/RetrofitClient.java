package com.example.weatherapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit instance = null;

    private API myApi;

    private RetrofitClient(){
        AnimatedStateListDrawableCompat GsonConverterFactory;
        Retrofit Retrofit = newRetrofit.Builder()
                .baseUrl (API.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = Retrofit.create(API.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if (instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public API getMyApi(){
        return myApi;
    }
}