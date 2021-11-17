package com.ktt.view;

import com.ktt.response.MessageResponse;

public interface IRegisterView {
    public void onRegisterComplete(MessageResponse messageResponse);
    public void onRegisterError(String message);
}
