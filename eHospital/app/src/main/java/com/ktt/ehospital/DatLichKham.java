package com.ktt.ehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DatLichKham extends AppCompatActivity {
    ImageButton imgBack;
    Button btnDatLich;
    TextView tvHienThiBacSi;
    EditText edtTenBN, edtNgaySinh, edtGioiTinh, edtDiaChi, edtSDT, edtNgayKham;
    ArrayList<String> dsKhoaKham, dsGioKham;
    ArrayList<infoBacSi> dsBacSi;
    BacSiAdapter adtBacSi;
    Spinner spinGioKham, spinKhoaKham, spinBacSi;
    String tenBN, ngaySinh, gioiTinh, diaChi, sdtBN, ngayKham, gioKham, khoaKham, tenBS, giaKham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_lich_kham);

        getView();
        //Thêm dữ liệu vào danh sách khoa khám, giờ khám, bác sĩ
        addKhoaKham();
        addGioKham();
        addBacSi();

        //Xử lý sự kiện
        eventBack(); // nút back trên đầu trang
        eventKhoaKham(); 
        eventGioKham();
        eventBacSi();
        eventChonNgay();
        //getThongTin();
        datLich();


    }

    private void getView(){
        imgBack = (ImageButton) findViewById(R.id.imgBack);
        edtTenBN = (EditText) findViewById(R.id.edtTenBN);
        edtNgaySinh = (EditText) findViewById(R.id.edtNgaySinh);
        edtGioiTinh = (EditText) findViewById(R.id.edtGioiTinh);
        edtDiaChi = (EditText) findViewById(R.id.edtDiaChi);
        edtSDT = (EditText) findViewById(R.id.edtSDT);
        edtNgayKham = (EditText) findViewById(R.id.edtNgayKham);
        btnDatLich = (Button) findViewById(R.id.btnDatLich);
        spinGioKham = (Spinner) findViewById(R.id.spinnerGioKham);
        spinKhoaKham = (Spinner) findViewById(R.id.spinnerKhoaKham);
        spinBacSi = (Spinner) findViewById(R.id.spinnerBacSi);
        tvHienThiBacSi = (TextView) findViewById(R.id.tvHienThiBacSi);
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

    private void addGioKham(){
        dsGioKham = new ArrayList<>();
        dsGioKham.add("08:00");
        dsGioKham.add("09:00");
        dsGioKham.add("10:00");
        dsGioKham.add("14:00");
        dsGioKham.add("15:00");
        dsGioKham.add("16:00");

    }

    private void addBacSi(){
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

    private void eventBack(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatLichKham.this, TrangChu.class);
                startActivity(intent);
            }
        });
    }

    private void eventKhoaKham(){
        //Gán data source (arr) vào adapter
        ArrayAdapter adtKhoaKham = new ArrayAdapter(
                DatLichKham.this,
                android.R.layout.simple_spinner_item,
                dsKhoaKham
        );
        //Lệnh hiển thị danh sách cho spinner
        adtKhoaKham.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho spinner
        spinKhoaKham.setAdapter(adtKhoaKham);
        //Thiết lập sự kiện chọn phần tử cho spinner
        spinKhoaKham.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int i, long l) {
                //đối số postion là vị trí phần tử trong list Data
                String msg = "position :" + i + " value :" + dsKhoaKham.get(i);
                //Toast.makeText(DatLichKham.this, msg, Toast.LENGTH_SHORT).show();
                khoaKham = dsKhoaKham.get(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(DatLichKham.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eventGioKham(){
        //Gán data source (arr) vào adapter
        ArrayAdapter adtGioKham = new ArrayAdapter(
                DatLichKham.this,
                android.R.layout.simple_spinner_item,
                dsGioKham
        );
        //Lệnh hiển thị danh sách cho spinner
        adtGioKham.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho spinner
        spinGioKham.setAdapter(adtGioKham);
        //Thiết lập sự kiện chọn phần tử cho spinner
        spinGioKham.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int i, long l) {
                //đối số postion là vị trí phần tử trong list Data
                String msg = "position :" + i + " value :" + dsGioKham.get(i);
                //Toast.makeText(DatLichKham.this, msg, Toast.LENGTH_SHORT).show();
                gioKham = dsGioKham.get(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(DatLichKham.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eventBacSi(){
        //Gán data source (arr) vào adapter
        BacSiAdapter adtBacSi = new BacSiAdapter(
                DatLichKham.this,
                R.layout.item_bac_si,
                dsBacSi
        );
        //Lệnh hiển thị danh sách cho spinner
        //adtBacSi.setDropDownViewResource(.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho spinner
        spinBacSi.setAdapter(adtBacSi);
        //Thiết lập sự kiện chọn phần tử cho spinner
        spinBacSi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int i, long l) {
                //đối số postion là vị trí phần tử trong list Data
                String msg = " Tên: " + dsBacSi.get(i).getName() + " Giá: " + dsBacSi.get(i).getPrice();
                //Toast.makeText(DatLichKham.this, msg, Toast.LENGTH_SHORT).show();
                tvHienThiBacSi.setText(msg);
                tenBS = dsBacSi.get(i).getName();
                giaKham = dsBacSi.get(i).getPrice();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(DatLichKham.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eventChonNgay(){
        edtNgayKham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
                ngayKham = edtNgayKham.getText().toString();
                //Toast.makeText(DatLichKham.this, ngayKham +"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ChonNgay(){
        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtNgayKham.setText(dateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    private void getThongTin(){
        edtTenBN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenBN = edtTenBN.getText().toString();
                Toast.makeText(DatLichKham.this, tenBN +"", Toast.LENGTH_SHORT).show();
            }
        });

        ngaySinh = edtNgaySinh.getText().toString();
        gioiTinh = edtGioiTinh.getText().toString();
        diaChi = edtDiaChi.getText().toString();
        sdtBN = edtSDT.getText().toString();
    }

    private void datLich(){
        btnDatLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenBN = edtTenBN.getText().toString();
                ngaySinh = edtNgaySinh.getText().toString();
                gioiTinh = edtGioiTinh.getText().toString();
                diaChi = edtDiaChi.getText().toString();
                sdtBN = edtSDT.getText().toString();
                ngayKham = edtNgayKham.getText().toString();
                Toast.makeText(
                        DatLichKham.this,
                        tenBN + "\n" + ngaySinh + "\n" +gioiTinh + "\n" + diaChi + "\n" + sdtBN + "\n"
                        + ngayKham +"\n" + gioKham +"\n" + khoaKham +"\n" + tenBS +"\n" + giaKham,
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(DatLichKham.this, DsLich.class);
                intent.putExtra("tenBN",tenBN);
                intent.putExtra("sdtBN",sdtBN);
                intent.putExtra("tenBS",tenBS);
                intent.putExtra("khoa",khoaKham);
                intent.putExtra("ngay",ngayKham);
                intent.putExtra("gio",gioKham);
                intent.putExtra("gia",giaKham);

                startActivity(intent);
            }
        });

    }
}