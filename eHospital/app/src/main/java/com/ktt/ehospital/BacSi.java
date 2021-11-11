package com.ktt.ehospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BacSi extends AppCompatActivity {

    ImageButton back;
    ListView lvBacSi;
    ArrayList<infoBacSi> dsBacSi;
    BacSiAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac_si);

        back = (ImageButton) findViewById(R.id.imgBack);

        //bắt sự kiện cho nút back trên thanh tiêu đề activity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BacSi.this, DatLich.class);
                startActivity(intent);
            }
        });

        getView();
        adapter = new BacSiAdapter(BacSi.this, R.layout.item_bac_si, dsBacSi);
        lvBacSi.setAdapter(adapter);

        //Bắt sự kiện cho mỗi item của listview
        lvBacSi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //i: vị trí click trên listview
                Intent intent = new Intent(BacSi.this, DatLich.class);
                startActivity(intent);

            }
        });
    }

    private void getView(){
        lvBacSi = (ListView) findViewById(R.id.lvBacSi);
        dsBacSi = new ArrayList<>();

        //add phần tử vào danh sách
        dsBacSi.add(new infoBacSi(
                "Đinh Tiến Trung",
                "Tiến sĩ",
                "15 năm kinh nghiệm",
                "300.000 VND",
                R.drawable.dinhtientrung));
        dsBacSi.add(new infoBacSi(
                "Trương Hiếu Nghĩa",
                "Thạc sĩ",
                "12 năm kinh nghiệm",
                "250.000 VND",
                R.drawable.truonghieunghia));
        dsBacSi.add(new infoBacSi(
                "Vũ Thị Thu Hằng",
                "Tiến sĩ",
                "14 năm kinh nghiệm",
                "300.000 VND",
                R.drawable.vuthithuhang));

    }
}