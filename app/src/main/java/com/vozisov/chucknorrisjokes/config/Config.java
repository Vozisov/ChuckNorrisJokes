package com.vozisov.chucknorrisjokes.config;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Config {

    static final String BASE_URL = "https://api.chucknorris.io/jokes/";

    @NonNull
    public static API getAPICategory() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        return retrofit.create(API.class);
    }

    @NonNull
    public static API getAPIJokes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(API.class);
    }
}
