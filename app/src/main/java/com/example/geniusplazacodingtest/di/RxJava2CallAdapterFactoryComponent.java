package com.example.geniusplazacodingtest.di;

import dagger.Component;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

@Component(modules = RxJava2CallAdapterFactoryModule.class)
public interface RxJava2CallAdapterFactoryComponent {
    RxJava2CallAdapterFactory getRxJava2CallAdapterFactory();
}
