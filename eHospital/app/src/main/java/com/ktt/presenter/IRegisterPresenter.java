package com.ktt.presenter;

import com.ktt.DTO.AccountDTO;
import com.ktt.DTO.RegisterAccountDTO;

public interface IRegisterPresenter {
    void sendAuthRegister(RegisterAccountDTO registerAccountDTO);
}
