package com.ktt.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ktt.request.AppointmentRequest;
import com.ktt.request.RegisterAccountRequest;
import com.ktt.response.Account;
import com.ktt.response.AppointmentResponse;
import com.ktt.response.Department;
import com.ktt.response.Doctor;
import com.ktt.response.MessageResponse;
import com.ktt.request.AccountRequest;
import com.ktt.response.ResponseJWT;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();


    APIService apiService = new Retrofit.Builder()
            .baseUrl("http:192.168.1.21:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .client(client)
            .build()
            .create(APIService.class);

    @POST("/api/auth/signin")
    Call<Account> sendLogin(@Body AccountRequest accountDTO);

    @POST("/api/auth/signup")
    Call<MessageResponse> sendAuthRegister(@Body RegisterAccountRequest registerAccountDTO);

    @GET("/api/v1/departments")
    Call<List<Department>> sendDatLichKham();

    @GET("/api/v1/doctors/department/id={id}")
    Call<List<Doctor>> sendListDoctor(@Path("id")int id);


    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("/api/v1/appointments/create")
    Call<ResponseJWT> sendCreateAppointment(@Body AppointmentRequest appointmentRequest, @Header("Authorization") String token);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("/api/v1/appointments/update")
    Call<ResponseJWT> sendUpdateAppointment(@Body AppointmentRequest appointmentRequest, @Header("Authorization") String token);


    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("/api/v1/appointments/id={id}")
    Call<List<AppointmentResponse>> sendListAppointments(@Path("id")int id, @Header("Authorization") String token);

    @GET("/api/v1/doctors/id={id}")
    Call<Doctor> sendDoctor(@Path("id")int id);

    @GET("/api/v1/departments/id={id}")
    Call<Department> sendDepartment(@Path("id")int id);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @PUT("/api/v1/appointments/abort/{id}")
    Call<ResponseJWT> sendAbortAppointment(@Path("id") int id, @Header("Authorization") String token);



}
