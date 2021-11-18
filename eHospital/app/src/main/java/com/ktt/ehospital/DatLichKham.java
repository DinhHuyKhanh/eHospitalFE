package com.ktt.ehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ktt.presenter.DatLichKhamPresenter;
import com.ktt.request.AppointmentRequest;
import com.ktt.response.AppointmentResponse;
import com.ktt.response.Department;
import com.ktt.response.Doctor;
import com.ktt.response.ResponseJWT;
import com.ktt.response.Session;
import com.ktt.view.IDatLichHenView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DatLichKham extends AppCompatActivity implements IDatLichHenView {
    ImageButton imgBack;
    Button btnDatLich;
    TextView tvHienThiBacSi;
    EditText edtTenBN, edtNgaySinh, edtDiaChi, edtSDT, edtNgayKham;
    ArrayList<String> dsKhoaKham, dsGioKham;
    ArrayList<infoBacSi> dsBacSi;
//    BacSiAdapter adtBacSi;
    Spinner spinGioKham, spinKhoaKham, spinBacSi;
    String tenBN, ngaySinh, gioiTinh, diaChi, sdtBN, ngayKham, gioKham, khoaKham, tenBS, giaKham;
    int departmentId, doctorId, id=0;
    private DatLichKhamPresenter datlichKhamPresenter;
    private List<Department> departmentList;
    private List<Doctor> doctorList;
    private AppointmentRequest request;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_lich_kham);

        getView();
        getInfoUser();
        //Thêm dữ liệu vào danh sách khoa khám, giờ khám, bác sĩ
//        addKhoaKham();
        addGioKham();
//        addBacSi();

        //Xử lý sự kiện
        eventBack(); // nút back trên đầu trang
//        eventKhoaKham();
        eventGioKham();
//        eventBacSi();
        eventChonNgay();
        getThongTin();
        datLich();
    }
    private void getInfoUser(){
        if(getIntent().getSerializableExtra("infoUser") != null){

            AppointmentResponse response = (AppointmentResponse) getIntent().getSerializableExtra("infoUser");
            id= response.getId();
            edtTenBN.setText(response.getFullName());
            edtNgaySinh.setText(response.getBirthday());
            edtDiaChi.setText(response.getAddress());
            edtSDT.setText(response.getNumberPhone());
        }
    }

    private void getView(){
        imgBack = (ImageButton) findViewById(R.id.imgBack);
        edtTenBN = (EditText) findViewById(R.id.edtTenBN);
        edtNgaySinh = (EditText) findViewById(R.id.edtNgaySinh);
//        edtGioiTinh = (EditText) findViewById(R.id.edtGioiTinh);
        edtDiaChi = (EditText) findViewById(R.id.edtDiaChi);
        edtSDT = (EditText) findViewById(R.id.edtSDT);
        edtNgayKham = (EditText) findViewById(R.id.edtNgayKham);
        btnDatLich = (Button) findViewById(R.id.btnDatLich);
        spinGioKham = (Spinner) findViewById(R.id.spinnerGioKham);
        spinKhoaKham = (Spinner) findViewById(R.id.spinnerKhoaKham);
        spinBacSi = (Spinner) findViewById(R.id.spinnerBacSi);
        tvHienThiBacSi = (TextView) findViewById(R.id.tvHienThiBacSi);
        datlichKhamPresenter = new DatLichKhamPresenter(this);
        datlichKhamPresenter.sendDepartment();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked)
                    // male
                    gioiTinh="Male";
                    break;
            case R.id.radio_female:
                if (checked)
                    // female
                    gioiTinh="Female";
                    break;
        }
    }

    private void addKhoaKham(){
        dsKhoaKham = new ArrayList<>();
        for (Department department: this.departmentList ) {
            dsKhoaKham.add(department.getDepartment().toString());
        }

        eventKhoaKham();

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
        for(Doctor doctor: doctorList){
            dsBacSi.add(new infoBacSi(
                    doctor.getFullName(),
                    doctor.getDegree(),
                    doctor.getExperience() +" năm kinh nghiệm",
                    doctor.getCost() +"VNĐ",
                    doctor.getGender().equals("Male")?R.drawable.dinhtientrung
                                                        :R.drawable.vuthithuhang)
            );
        }
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
                System.out.println("data" + msg);
//                Toast.makeText(DatLichKham.this, msg, Toast.LENGTH_SHORT).show();
                khoaKham = dsKhoaKham.get(i);
               setDepartmentId(i+1);
                datlichKhamPresenter.sendDoctorByDepartmentId( (i+1) );
                //                eventBacSi();
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
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
        diaChi = edtDiaChi.getText().toString();
        sdtBN = edtSDT.getText().toString();
    }

    private void datLich(){
        btnDatLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenBN = edtTenBN.getText().toString();
                ngaySinh = edtNgaySinh.getText().toString();
                diaChi = edtDiaChi.getText().toString();
                sdtBN = edtSDT.getText().toString();
                ngayKham = edtNgayKham.getText().toString();
                Toast.makeText(
                        DatLichKham.this,
                        tenBN + "\n" + ngaySinh + "\n" +gioiTinh + "\n" + diaChi + "\n" + sdtBN + "\n"
                        + ngayKham +"\n" + gioKham +"\n" + khoaKham +"\n" + tenBS +"\n" + giaKham,
                        Toast.LENGTH_LONG).show();

                AppointmentRequest appointmentRequest = new AppointmentRequest();
                for (Doctor doctor:doctorList) {
                    if(doctor.getFullName().equals(tenBS)){
                        setDoctorId(doctor.getId());
                        break;
                    }
                }
                Session session = new Session(getApplicationContext());
//                System.out.println("id is: " + session.getId());
                appointmentRequest.setId(id);
                appointmentRequest.setFullName(tenBN);
                appointmentRequest.setBirthday(ngaySinh);
                appointmentRequest.setAddress(diaChi);
                appointmentRequest.setGender(gioiTinh);
                appointmentRequest.setNumberPhone(sdtBN);
                appointmentRequest.setDateAppointment(ngayKham+" "+gioKham);
                appointmentRequest.setAccountId(session.getId());
                appointmentRequest.setDoctorId(getDoctorId());
                appointmentRequest.setDepartmentId(getDepartmentId());
                System.out.println("btn SDT" + doctorId + departmentId);

                if(id==0){
                    datlichKhamPresenter.sendCreateAppointment(appointmentRequest, session.getAccessToken());
                    System.out.println("create");
                }else{
                    datlichKhamPresenter.sendUpdateAppointment(appointmentRequest,session.getAccessToken());
                    System.out.println("update");
                }
            }
        });

    }

    @Override
    public void onDepartmentComplete(List<Department> departmentList) {
        setDepartmentList(departmentList);
        addKhoaKham();
    }

    @Override
    public void onDepartmentError(String message) {
        System.out.println("erorr:" + message);
    }

    @Override
    public void onDoctorComplete(List<Doctor> doctorList) {
        setDoctorList(doctorList);
        addBacSi();
        eventBacSi();
    }

    @Override
    public void onDoctorError(String message) {

    }

    @Override
    public void onCreateAppointmentComplete(ResponseJWT responseJWT) {
           if(responseJWT.getMessage().equals("status: 200")){
               System.out.println("Successfully !");
               Intent intent = new Intent(DatLichKham.this,DsLich.class);
               startActivity(intent);
           }else System.out.println("comp" + responseJWT.getMessage() + responseJWT.getData());
    }

    @Override
    public void onAppointmentError(String message) {
    }

    @Override
    public void onUpdateAppointmentComplete(ResponseJWT responseJWT) {
        if(responseJWT.getMessage().equals("status: 200")){
            System.out.println("Successfully !");
            Intent intent = new Intent(DatLichKham.this,DsLich.class);
            startActivity(intent);
        }else System.out.println("comp" + responseJWT.getMessage() + responseJWT.getData());
    }

    @Override
    public void onUpdateAppointmentError(String message) {

    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
}