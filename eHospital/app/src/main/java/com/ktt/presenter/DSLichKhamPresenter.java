package com.ktt.presenter;

import com.ktt.model.APIService;
import com.ktt.response.AppointmentResponse;
import com.ktt.response.Session;
import com.ktt.view.IDSLichKhamView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DSLichKhamPresenter implements  IDSLichKhamPresenter{

    private IDSLichKhamView dsLichKhamView;

    public DSLichKhamPresenter(IDSLichKhamView dsLichKhamView)
    {
        this.dsLichKhamView = dsLichKhamView;
    }

    @Override
    public void sendDSLichKham(int id, String token) {
        APIService.apiService.sendListAppointments(id,"Bearer "+token).enqueue(new Callback<List<AppointmentResponse>>() {
            @Override
            public void onResponse(Call<List<AppointmentResponse>> call, Response<List<AppointmentResponse>> response) {
                System.out.println("id :" + id + "otken" + token);
                if(response.body() != null){
                    dsLichKhamView.onDSLichComplete(response.body());
                }else{
                    dsLichKhamView.onDSLichError("null");
                }
            }

            @Override
            public void onFailure(Call<List<AppointmentResponse>> call, Throwable t) {
                dsLichKhamView.onDSLichError("error: " + t.getMessage());
            }
        });
    }
}
