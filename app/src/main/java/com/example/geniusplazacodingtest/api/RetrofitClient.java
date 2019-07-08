package com.example.geniusplazacodingtest.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofitClient;

    //This the url where all calls will be made
    private static final String BASE_URL = "https://reqres.in/api/";

    public Retrofit getRetrofitClient()
    {
        //Create a client if it doesn't exist and return
        if(retrofitClient == null){
            //Note: We will be using GsonConverterFactory.
            retrofitClient = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Return the existing client
        return retrofitClient;
    }
}
