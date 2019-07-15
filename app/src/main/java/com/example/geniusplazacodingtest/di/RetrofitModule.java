package com.example.geniusplazacodingtest.di;

import javax.inject.Singleton;

import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModule {
    @Provides
    @Singleton
    public Retrofit provideRetrofit()
    {
        Retrofit client;
        String BASE_URL = "https://reqres.in/api/";

        client = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        return client;
    }
}
