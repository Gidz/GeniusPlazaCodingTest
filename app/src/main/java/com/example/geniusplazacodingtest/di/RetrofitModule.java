package com.example.geniusplazacodingtest.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module( includes = {GsonConverterFactoryModule.class, RxJava2CallAdapterFactoryModule.class} )
public class RetrofitModule {
    @Provides
    @Singleton
    public Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory)
    {
        Retrofit client;
        String BASE_URL = "https://api.darksky.net/";

        client = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .build();

        return client;
    }
}
