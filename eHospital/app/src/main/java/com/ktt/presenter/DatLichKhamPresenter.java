package com.ktt.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.ktt.ehospital.LoginActivity;
import com.ktt.model.APIService;
import com.ktt.request.AppointmentRequest;
import com.ktt.response.Department;
import com.ktt.response.Doctor;
import com.ktt.response.ResponseJWT;
import com.ktt.view.IDatLichHenView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatLichKhamPresenter implements IDatLichKhamPresenter {

    private IDatLichHenView datLichHenView;

    public DatLichKhamPresenter(IDatLichHenView datLichHenView){
        this.datLichHenView = datLichHenView;
    }
    @Override
    public void sendDepartment() {
        APIService.apiService.sendDatLichKham().enqueue(new Callback<List<Department>>() {
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                if(response.body()!=null){
                    datLichHenView.onDepartmentComplete(response.body());
                }else{
                    datLichHenView.onDepartmentError("null");
                }
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
                datLichHenView.onDepartmentError(t.getMessage());
            }
        });
    }

    @Override
    public void sendDoctorByDepartmentId(int id) {
        APIService.apiService.sendListDoctor(id).enqueue(new Callback<List<Doctor>>() {
            @Override
            public void onResponse(Call<List<Doctor>> call, Response<List<Doctor>> response) {
                datLichHenView.onDoctorComplete(response.body());
            }

            @Override
            public void onFailure(Call<List<Doctor>> call, Throwable t) {
                datLichHenView.onDoctorError("error: " + t.getMessage());
            }
        });

    }

    @Override
    public void sendCreateAppointment(AppointmentRequest appointmentRequest, String token) {
        APIService.apiService.sendCreateAppointment(appointmentRequest, token).enqueue(new Callback<ResponseJWT>() {
            @Override
            public void onResponse(Call<ResponseJWT> call, Response<ResponseJWT> response) {
                datLichHenView.onCreateAppointmentComplete(response.body());
            }

            @Override
            public void onFailure(Call<ResponseJWT> call, Throwable t) {
                datLichHenView.onAppointmentError(t.getMessage());
            }
        });
    }


}
