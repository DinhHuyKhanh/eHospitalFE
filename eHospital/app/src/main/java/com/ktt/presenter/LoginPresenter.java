package com.ktt.presenter;

import com.ktt.request.AccountRequest;
import com.ktt.response.Account;
import com.ktt.model.APIService;
import com.ktt.view.ILoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements  ILoginPresenter{

    private ILoginView loginView;
    private APIService apiService;


    public LoginPresenter(ILoginView loginView){
        this.loginView = loginView;
    }

     public void sendAccount(AccountRequest accountDTO){
        APIService.apiService.sendLogin(accountDTO).enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if(response.body() != null){
                    loginView.onComplete(response.body());
                }else{
                    loginView.onError("null");
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                loginView.onError(t.getMessage());
            }

        });
    }
}
