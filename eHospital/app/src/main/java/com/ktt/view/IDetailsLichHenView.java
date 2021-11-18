package com.ktt.view;

import com.ktt.response.ResponseJWT;

public interface IDetailsLichHenView {
    void onAbortComplete(ResponseJWT responseJWT);
    void onAbortError(String message);

}
