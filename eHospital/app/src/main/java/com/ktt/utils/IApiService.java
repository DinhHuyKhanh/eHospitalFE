package com.ktt.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ktt.entities.Account;
import com.ktt.response.AccountDTO;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IApiService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    IApiService apiService = new Retrofit.Builder()
            .baseUrl(domain.urlAuth)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(IApiService.class);

    @POST("/signin")
    Call<AccountDTO> sendAccount(@Body Account account);
}
