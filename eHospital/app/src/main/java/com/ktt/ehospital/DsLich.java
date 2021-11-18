package com.ktt.ehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.ktt.presenter.DSLichKhamPresenter;
import com.ktt.response.AppointmentResponse;
import com.ktt.response.Session;
import com.ktt.view.IDSLichKhamView;

import java.util.ArrayList;
import java.util.List;

public class DsLich extends AppCompatActivity implements IDSLichKhamView {
     ListView lvds;
     DsAdapter dsAdapter;
     ImageButton imgBackDS;
     private List<AppointmentResponse> appointmentResponseList;
     private DSLichKhamPresenter dsLichKhamPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ds_lich_hen);
        lvds = (ListView) findViewById(R.id.lviewDS);
        imgBackDS= (ImageButton) findViewById(R.id.imgBackDS);

        imgBackDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DsLich.this,TrangChu.class);
                startActivity(intent);
            }
        });

        dsLichKhamPresenter = new DSLichKhamPresenter(this);
        Session session = new Session(getApplicationContext());
        dsLichKhamPresenter.sendDSLichKham(session.getId(),session.getAccessToken());

//        lvds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                AppointmentResponse appointmentResponse = (AppointmentResponse) lvds.getAdapter().getItem(position);
//                Intent intent = new Intent(DsLich.this,detailLichHen.class);
//                lvds.getContext().startActivity(intent);
//            }
//        });

    }

    @Override
    public void onDSLichComplete(List<AppointmentResponse> appointmentResponseList) {
        dsAdapter = new DsAdapter(DsLich.this, R.layout.dong_ds,appointmentResponseList);
        lvds.setAdapter(dsAdapter) ;
//        lvds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                AppointmentResponse appointmentResponse = (AppointmentResponse) lvds.getAdapter().getItem(position);
//                Intent intent = new Intent(DsLich.this,detailLichHen.class);
//                lvds.getContext().startActivity(intent);
//            }
//        });
       this.appointmentResponseList = appointmentResponseList;
    }

    @Override
    public void onDSLichError(String message) {
        System.out.println("messs" + message);
    }
}