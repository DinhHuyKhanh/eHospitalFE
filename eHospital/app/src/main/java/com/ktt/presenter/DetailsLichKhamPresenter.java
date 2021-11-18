package com.ktt.presenter;

import com.ktt.model.APIService;
import com.ktt.request.AppointmentRequest;
import com.ktt.response.ResponseJWT;
import com.ktt.view.IDetailsLichHenView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsLichKhamPresenter implements  IDetailsLichKhamPresenter{

    private IDetailsLichHenView view;

    public DetailsLichKhamPresenter(IDetailsLichHenView view){
        this.view = view;
    }

    @Override
    public void SendAbortAppointment(int id, String token) {
        APIService.apiService.sendAbortAppointment(id,"Bearer " + token).enqueue(new Callback<ResponseJWT>() {
            @Override
            public void onResponse(Call<ResponseJWT> call, Response<ResponseJWT> response) {
                if(response.body().getMessage().equals("status: 200"))
                    view.onAbortComplete(response.body());
                else view.onAbortError(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ResponseJWT> call, Throwable t) {
                view.onAbortError("error");
            }
        });
    }
}
