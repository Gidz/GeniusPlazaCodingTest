package com.example.geniusplazacodingtest.di;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
@Component(modules = GsonConverterFactoryModule.class)
public interface GsonConverterFactoryComponent {
    GsonConverterFactory getGsonConverterFactory();
}
