package com.ktt.ehospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnSignIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSignUp.setOnClickListener(item->{
            Intent intent = new Intent(MainActivity.this,activity_register.class);
            startActivity(intent);
            finish();
        });

    }
}