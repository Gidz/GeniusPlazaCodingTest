package com.example.geniusplazacodingtest.di;

import com.example.geniusplazacodingtest.api.ApiCallInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module( includes = RetrofitModule.class )
public class ApiCallInterfaceModule {

    @Singleton
    @Provides
    ApiCallInterface getApi(Retrofit retrofit) {
        return retrofit.create(ApiCallInterface.class);
    }

}
