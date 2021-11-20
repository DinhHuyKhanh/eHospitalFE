package com.ktt.ehospital;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ktt.request.RegisterAccountRequest;
import com.ktt.response.MessageResponse;
import com.ktt.presenter.RegisterPresenter;
import com.ktt.view.IRegisterView;

public class activity_register extends AppCompatActivity implements IRegisterView {

    private TextView txtUsername, txtPassword;
    private Button btnRegister, btnCancel;
    private RegisterPresenter registerPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUsername = findViewById(R.id.usernameSignUp);
        txtPassword = findViewById(R.id.passwordSignUp);
        btnRegister = findViewById(R.id.register);
        btnCancel = findViewById(R.id.cancel);

        btnRegister.setOnClickListener(item->{
            RegisterAccountRequest registerAccountDTO = new RegisterAccountRequest();
            registerAccountDTO.setPassword(txtPassword.getText().toString());
            registerAccountDTO.setUsername(txtUsername.getText().toString());

            registerPresenter = new RegisterPresenter(this);
            registerPresenter.sendAuthRegister(registerAccountDTO);


        });

        btnCancel.setOnClickListener(item->{
            Intent intent = new Intent(activity_register.this, LoginActivity.class);
            startActivity(intent);
        });
    }


    @Override
    public void onRegisterComplete(MessageResponse messageResponse) {
        if(messageResponse.getMessage()!=null){
            Toast.makeText(activity_register.this,messageResponse.getMessage(),Toast.LENGTH_SHORT);
            Intent intent = new Intent(activity_register.this, LoginActivity.class);
            startActivity(intent);

        }else{
            Toast.makeText(activity_register.this,"error",Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onRegisterError(String message) {
        Toast.makeText(activity_register.this,"error",Toast.LENGTH_SHORT);
    }
}