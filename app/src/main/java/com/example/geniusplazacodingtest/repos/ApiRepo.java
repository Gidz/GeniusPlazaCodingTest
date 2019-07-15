package com.example.geniusplazacodingtest.repos;

import android.util.Log;

import com.example.geniusplazacodingtest.api.ApiCallInterface;
import com.example.geniusplazacodingtest.di.ApiCallInterfaceComponent;
import com.example.geniusplazacodingtest.di.DaggerApiCallInterfaceComponent;
import com.example.geniusplazacodingtest.models.JsonResponse;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ApiRepo {

    private static String TAG = "ApiRepo";


    ApiCallInterfaceComponent apiCallInterfaceComponent;
    ApiCallInterface service;

    Observable<JsonResponse> jsonResponseObservable;

    //Constructor
    public ApiRepo() {
        //DI
        apiCallInterfaceComponent = DaggerApiCallInterfaceComponent.create();
        service = apiCallInterfaceComponent.getApiCallInterface();
        jsonResponseObservable = service.getData().subscribeOn(Schedulers.io());
    }

    //Getters
    public Observable<JsonResponse> getJsonResponseObservable(){
            return jsonResponseObservable;
    }

}
