package com.example.geniusplazacodingtest.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.geniusplazacodingtest.models.JsonResponse;
import com.example.geniusplazacodingtest.models.User;
import com.example.geniusplazacodingtest.repos.ApiRepo;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivityViewModel extends ViewModel {

    private static String TAG = "MainActivityViewModel";

    private ArrayList<User> latestUserData;

    private Observable<JsonResponse> jsonResponseObservable;
    private Observer<JsonResponse> jsonResponseObserver;

    private ApiRepo repo;

    public MutableLiveData<ArrayList<User>> userDataMutableLiveData;

    public MainActivityViewModel(){

        //Get the repo
        repo = new ApiRepo();

        userDataMutableLiveData = new MutableLiveData<ArrayList<User>>();

        /* Start RxJava Subscription */
        jsonResponseObservable = repo.getJsonResponseObservable();
        jsonResponseObserver = createAndGetObserver();

        //Subscribe
        jsonResponseObservable.subscribe(jsonResponseObserver);
        /* End RxJava Subscription */

        Log.e(TAG, "Created view model");

    }

    private Observer<JsonResponse> createAndGetObserver() {
        return new Observer<JsonResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse jsonResponse) {
                userDataMutableLiveData.postValue(jsonResponse.getData());
                Log.e(TAG,"Got the data!");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.toString());
            }

            @Override
            public void onComplete() {

            }
        };
    }

    public MutableLiveData<ArrayList<User>> getUserDataMutableLiveData() {
        return userDataMutableLiveData;
    }
}
