package com.example.geniusplazacodingtest.repos;

import com.example.geniusplazacodingtest.api.ApiCallInterface;
import com.example.geniusplazacodingtest.di.ApiCallInterfaceComponent;
import com.example.geniusplazacodingtest.di.DaggerApiCallInterfaceComponent;
import com.example.geniusplazacodingtest.models.JsonResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepo {


    ApiCallInterfaceComponent apiCallInterfaceComponent;
    ApiCallInterface service;

    //Constructor
    public ApiRepo() {
        //DI
        apiCallInterfaceComponent = DaggerApiCallInterfaceComponent.create();
        service = apiCallInterfaceComponent.getApiCallInterface();
    }

}
