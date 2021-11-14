package com.ktt.view;

import com.ktt.entities.Account;
import com.ktt.entities.MessageResponse;
import com.ktt.entities.ResponseJWT;

public interface IRegisterView {
    public void onRegisterComplete(MessageResponse messageResponse);
    public void onRegisterError(String message);
}
