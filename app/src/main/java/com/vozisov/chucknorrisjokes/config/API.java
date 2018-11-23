package com.vozisov.chucknorrisjokes.config;

import com.vozisov.chucknorrisjokes.model.Joke;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("categories")
    Call<String> getCategories();

    @GET("random")
    Call<Joke> getJoke();
}
