package com.ktt.presenter;

import com.ktt.DTO.AccountDTO;
import com.ktt.DTO.RegisterAccountDTO;
import com.ktt.entities.MessageResponse;
import com.ktt.entities.ResponseJWT;
import com.ktt.model.APIService;
import com.ktt.view.IRegisterView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements  IRegisterPresenter{

     private IRegisterView registerView;

    public RegisterPresenter(IRegisterView registerView){
        this.registerView = registerView;
    }

    @Override
    public void sendAuthRegister(RegisterAccountDTO registerAccountDTO) {
        APIService.apiService.sendAuthRegister(registerAccountDTO).enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                if(response != null){
                    registerView.onRegisterComplete(response.body());
                }else{
                    registerView.onRegisterError("null");
                }
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
                registerView.onRegisterError(t.getMessage());
            }
        });
    }
}
