package com.example.geniusplazacodingtest.api;

import com.example.geniusplazacodingtest.models.JsonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserAPI {
    //Response for users will be a of JsonResponse model type.
    @GET("users")
    Call<JsonResponse> getData();
}
