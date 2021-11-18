package com.ktt.presenter;

import com.ktt.request.RegisterAccountRequest;

public interface IRegisterPresenter {
    void sendAuthRegister(RegisterAccountRequest registerAccountDTO);
}
