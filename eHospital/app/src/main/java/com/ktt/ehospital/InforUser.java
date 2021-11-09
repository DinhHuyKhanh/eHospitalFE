package com.ktt.ehospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class InforUser extends AppCompatActivity {
    ImageButton imgBackInfor;
    Button btnDatLich;
    EditText editName,editBirth, editGioiTinh, editDiaChi,editSDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_user);

        imgBackInfor = (ImageButton) findViewById(R.id.imgBackInfor);
        editName     = (EditText) findViewById(R.id.editName);
        editBirth    = (EditText) findViewById(R.id.editBirth);
        editGioiTinh = (EditText) findViewById(R.id.editGioiTinh);
        editDiaChi   = (EditText) findViewById(R.id.editDiaChi);
        editSDT      = (EditText) findViewById(R.id.editSDT);
        btnDatLich   = (Button) findViewById(R.id.btnDatLich);

        //bắt sự kiện trở lại trang trc
        imgBackInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InforUser.this, NgayGio.class);
                startActivity(intent);
            }
        });
        btnDatLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}