package com.ktt.ehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class DsLich extends AppCompatActivity {
     ListView lvds;
     DsAdapter dsAdapter;
     ImageButton imgBackDS;
     ArrayList<LichKham> lichKhamArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ds_lich_hen);
        lvds = (ListView) findViewById(R.id.lviewDS);
        imgBackDS= (ImageButton) findViewById(R.id.imgBackDS);
        imgBackDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(DsLich.this,DatLichKham.class);
                startActivity(in);
            }
        });
        lichKhamArrayList = new ArrayList<>();
        Intent intent = getIntent();
        String tenBNhan = intent.getStringExtra("tenBN");
        String sdtBNhan = intent.getStringExtra("sdtBN");
        String tenBSi = intent.getStringExtra("tenBS");
        String khoa = intent.getStringExtra("khoa");
        String ngay = intent.getStringExtra("ngay");
        String gio = intent.getStringExtra("gio");
        String gia = intent.getStringExtra("gia");

        lichKhamArrayList.add(new LichKham(tenBNhan,sdtBNhan,tenBSi,khoa,ngay,gio,gia,"Wait!"));
        dsAdapter = new DsAdapter(DsLich.this, R.layout.dong_ds,lichKhamArrayList);
        lvds.setAdapter(dsAdapter);



    }
}