package com.ktt.ehospital;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_register extends AppCompatActivity {

    private TextView txtUsername, txtPassword;
    private Button btnUserName, btnPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUsername = findViewById(R.id.usernameSignUp);
        txtPassword = findViewById(R.id.passwordSignUp);

    }
    
}