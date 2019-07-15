package com.example.geniusplazacodingtest.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class GsonConverterFactoryModule {

    @Singleton
    @Provides
    public GsonConverterFactory provideGsonConverterFactory()
    {
        return GsonConverterFactory.create();
    }
}
