package com.ktt.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ktt.DTO.RegisterAccountDTO;
import com.ktt.entities.Account;
import com.ktt.entities.MessageResponse;
import com.ktt.entities.ResponseJWT;
import com.ktt.DTO.AccountDTO;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();


    APIService apiService = new Retrofit.Builder()
            .baseUrl("http:192.168.197.1:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .client(client)
            .build()
            .create(APIService.class);

    @POST("/api/auth/signin")
    Call<Account> sendLogin(@Body AccountDTO accountDTO);

    @POST("/api/auth/signup")
    Call<MessageResponse> sendAuthRegister(@Body RegisterAccountDTO registerAccountDTO);



}
