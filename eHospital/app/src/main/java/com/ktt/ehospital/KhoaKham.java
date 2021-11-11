package com.ktt.ehospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class KhoaKham extends AppCompatActivity {

    ImageButton back;
    ListView lvKhoaKham;
    ArrayList<String> dsKhoaKham;
    String khoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoa_kham);

        back = (ImageButton) findViewById(R.id.imgBack);
        lvKhoaKham = (ListView) findViewById(R.id.lvKhoaKham);

        addKhoaKham(); //thêm khoa khám vào danh sách

        //bắt sự kiện cho nút back trên thanh tiêu đề activity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KhoaKham.this, DatLich.class);
                startActivity(intent);
            }
        });

        ArrayAdapter adt = new ArrayAdapter(
                KhoaKham.this,
                android.R.layout.simple_list_item_1,
                dsKhoaKham
        );

        lvKhoaKham.setAdapter(adt);

        //Bắt sự kiện cho mỗi item của listview
        lvKhoaKham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //i: vị trí click trên listview
                //Toast.makeText(KhoaKham.this, ""+i, Toast.LENGTH_SHORT).show();
                //Toast.makeText(KhoaKham.this, dsKhoaKham.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(KhoaKham.this, DatLich.class);
                khoa = dsKhoaKham.get(i);
                intent.putExtra("KhoaKham",khoa);
                startActivity(intent);

            }
        });
    }

    private void addKhoaKham(){
        dsKhoaKham = new ArrayList<>();
        dsKhoaKham.add("Tai - Mũi - Họng");
        dsKhoaKham.add("Nội tổng quát");
        dsKhoaKham.add("Cơ xương khớp");
        dsKhoaKham.add("Tiêu hóa");
        dsKhoaKham.add("Thần kinh");
        dsKhoaKham.add("Tim mạch");
    }
}