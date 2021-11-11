package com.ktt.ehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DatLich extends AppCompatActivity {

    ImageButton back;
    Button btnInfoUser, btnKhoaKham, btnBacSi, btnNgayGio, btnDatLich;
    TextView tvInfoUser, tvKhoaKham, tvBacSi, tvNgayGio;
    String tenBN, sdtBN, khoaKham, tenBS, ngayKham, gioKham, giaKham, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_lich);

        getView();

        //bắt sự kiện cho nút back trên thanh tiêu đề activity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatLich.this, TrangChu.class);
                startActivity(intent);
            }
        });

//        btnInfoUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DatLich.this, InforUser.class);
//                startActivity(intent);
//            }
//        });
//
//        btnKhoaKham.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DatLich.this, KhoaKham.class);
//                startActivity(intent);
//            }
//        });
//
//        btnBacSi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DatLich.this, BacSi.class);
//                startActivity(intent);
//            }
//        });
//
//        btnNgayGio.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DatLich.this, NgayGio.class);
//                startActivity(intent);
//            }
//        });

//        Intent intent = getIntent();
//        khoaKham = intent.getStringExtra("KhoaKham");
//        Toast.makeText(DatLich.this, khoaKham, Toast.LENGTH_SHORT).show();
//        tvKhoaKham.setText(khoaKham);

    }

    private void getView(){
        back = (ImageButton) findViewById(R.id.imgBack);
//        btnInfoUser = (Button) findViewById(R.id.btnInfoUser);
//        btnKhoaKham = (Button) findViewById(R.id.btnKhoaKham);
//        btnBacSi = (Button) findViewById(R.id.btnBacSi);
//        btnNgayGio = (Button) findViewById(R.id.btnNgayGio);
//        btnDatLich = (Button) findViewById(R.id.btnDatLich);
//        tvInfoUser = (TextView) findViewById(R.id.tvInfoUser);
//        tvKhoaKham = (TextView) findViewById(R.id.tvKhoaKham);
//        tvBacSi = (TextView) findViewById(R.id.tvBacSi);
//        tvNgayGio = (TextView) findViewById(R.id.tvNgayGio);
    }
}