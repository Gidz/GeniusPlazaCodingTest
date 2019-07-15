package com.example.geniusplazacodingtest.di;

import dagger.Module;
import dagger.Provides;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

@Module
public class RxJava2CallAdapterFactoryModule {
    @Provides
    public RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory(){
        return RxJava2CallAdapterFactory.create();
    }
}
