package com.example.geniusplazacodingtest.di;

import com.example.geniusplazacodingtest.api.ApiCallInterface;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApiCallInterfaceModule.class)
public interface ApiCallInterfaceComponent {
    ApiCallInterface getApiCallInterface();
}
