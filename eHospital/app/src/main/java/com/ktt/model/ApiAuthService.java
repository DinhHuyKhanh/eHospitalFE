package com.ktt.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ktt.entities.Account;
import com.ktt.response.AccountDTO;
import com.ktt.utils.domain;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiAuthService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiAuthService apiService = new Retrofit.Builder()
            .baseUrl(domain.urlAuth)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiAuthService.class);

    @POST("signin")
    Call<Account> sendAccount(@Body AccountDTO accountDTO);



}
