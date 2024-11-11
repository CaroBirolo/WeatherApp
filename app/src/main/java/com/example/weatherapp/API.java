package com.example.weatherapp;

import kotlin.text.UStringsKt;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    String Base_URL = "https://api.openweathermap.org/data/2.5/";
    String TOKEN = "6e23d982935ae935c9805cbe2aa789b6";
    String UNITS = "metric";
    String LANG = "es";


    @GET("weather")
    Call<Results> getCurrentWeather(
            @Query("lat") Float latitud,
            @Query("long") Float longitud,
            @Query("appId") String token,
            @Query("units") String units,
            @Query("lang") String lang;
    );
}