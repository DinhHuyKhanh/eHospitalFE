package com.ktt.ehospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.banner.BannerView;

public class TrangChu extends AppCompatActivity {
    Button btnDatLich,btnLichKham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        HwAds.init(this);
        BannerView bottomBannerView = findViewById(R.id.banner);
        AdParam adParam = new AdParam.Builder().build();
        bottomBannerView.loadAd(adParam);

        btnDatLich = (Button) findViewById(R.id.btnKhoa);
        btnLichKham = (Button) findViewById(R.id.btnLichKham);

        btnDatLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChu.this, DatLichKham.class);
                startActivity(intent);
            }
        });
        btnLichKham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(TrangChu.this,DsLich.class);
                startActivity(in);
            }
        });
    }

    void setBtnLichKham(){
        btnLichKham.setOnClickListener(item->{
            Intent intent = new Intent(TrangChu.this, DsLich.class);
            startActivity(intent);
        });
    }
}