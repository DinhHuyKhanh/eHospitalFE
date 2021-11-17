package com.ktt.view;

import com.ktt.response.Account;

public interface ILoginView {
    public void onComplete(Account account);
    public void onError(String message);
}
