package com.example.geniusplazacodingtest.api;

import com.example.geniusplazacodingtest.models.JsonResponse;
import com.example.geniusplazacodingtest.models.User;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiCallInterface {
    //Response for users will be a of JsonResponse model type.
    @GET("users")
    Call<JsonResponse> getData();

    @POST("users")
    @FormUrlEncoded

    Call<User> addUser(
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("last_name") String last_name
    );
}
