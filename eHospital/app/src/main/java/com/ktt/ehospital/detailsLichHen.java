package com.ktt.ehospital;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.telecom.Call;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.huawei.hms.ads.App;
import com.ktt.presenter.DetailsLichKhamPresenter;
import com.ktt.request.AppointmentRequest;
import com.ktt.response.AppointmentResponse;
import com.ktt.response.ResponseJWT;
import com.ktt.response.Session;
import com.ktt.view.IDetailsLichHenView;

public class detailsLichHen extends AppCompatActivity implements IDetailsLichHenView {

    private TextView txtTenBN,txtNgaySinh,txtGT,txtDiaChi,
            txtSDT,txtNgayKham,txtKhoaKham,txtBacSi,txtHocVi,
            txtChiPhi,txtStatus,txtKinhNghiem;
    private Button btnHuy, btnChinhSua;
    private ImageButton btnBack;

    private AppointmentResponse appointmentResponse;
    private DetailsLichKhamPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lich_hen);
        getView();
        setInfoUser();
        setBtnBack();
        setBtnHuy();
        setBtnChinhSua();
    }

    void setInfoUser(){
        Intent intent = getIntent();
        if(intent.getSerializableExtra("infoUser") != null){
            appointmentResponse = (AppointmentResponse) getIntent().getSerializableExtra("infoUser");
            txtTenBN.setText(appointmentResponse.getFullName());
            txtNgaySinh.setText(appointmentResponse.getBirthday());
            txtDiaChi.setText(appointmentResponse.getAddress());
            txtSDT.setText(appointmentResponse.getNumberPhone());
            txtNgayKham.setText(appointmentResponse.getDateAppointment());

            txtKhoaKham.setText(appointmentResponse.getDepartment());
            txtBacSi.setText(appointmentResponse.getDoctorName());
            txtHocVi.setText(appointmentResponse.getDegree());
            txtKinhNghiem.setText(appointmentResponse.getDoctorExperience() + " năm kinh nghiệm" );
            txtChiPhi.setText(appointmentResponse.getDoctorPrice() + " VNĐ" );

            if(appointmentResponse.getStatus().equals("PENDING")){
                txtStatus.setText("Chờ xác nhận.");
                btnChinhSua.setEnabled(true);
                btnHuy.setEnabled(true);
            }else if(appointmentResponse.getStatus().equals("ABORT")){
                txtStatus.setText("Đã hủy.");
                btnChinhSua.setEnabled(false);
                btnHuy.setEnabled(false);
            }else{
                txtStatus.setText("Đã đặt lịch thành công.");
                btnChinhSua.setEnabled(false);
                btnHuy.setEnabled(false);
            }
            if(appointmentResponse.getGender() !=null) {

                if (appointmentResponse.getGender().equals("Male")) {
                    txtGT.setText("Nam");
                } else if (appointmentResponse.getGender().equals("Female")) {
                    txtGT.setText("Nữ");
                }
            }
        }
    }
    void getView(){
        txtTenBN = findViewById(R.id.txtTenBN);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        txtGT = findViewById(R.id.txtGT);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        txtSDT = findViewById(R.id.txtSDT);
        txtNgayKham = findViewById(R.id.txtNgayKham);
        txtKhoaKham = findViewById(R.id.txtKhoaKham);
        txtKhoaKham = findViewById(R.id.txtKhoaKham);
        txtBacSi = findViewById(R.id.txtBacSi);
        txtHocVi = findViewById(R.id.txtHocVi);
        txtChiPhi = findViewById(R.id.txtChiPhi);
        txtStatus = findViewById(R.id.txtStatus);
        txtKinhNghiem = findViewById(R.id.txtKinhNghiem);
        txtStatus = findViewById(R.id.txtStatus);
        btnBack = findViewById(R.id.imgBack);
        btnHuy = findViewById(R.id.huy);
        btnChinhSua = findViewById(R.id.chinhSua);
    }

    void setBtnBack(){
        btnBack.setOnClickListener(item->{
            Intent intent = new Intent(detailsLichHen.this,TrangChu.class);
            startActivity(intent);
        });
    }

    /**
     * sự kiện: hủy lịch hẹn
     */
    void setBtnHuy(){
        btnHuy.setOnClickListener(item->{
            Session session = new Session(this);
            presenter = new DetailsLichKhamPresenter(this);
            presenter.SendAbortAppointment(appointmentResponse.getId(), session.getAccessToken());
        });
    }
    void setBtnChinhSua(){
        btnChinhSua.setOnClickListener(item->{
            Intent intent = new Intent(detailsLichHen.this, DatLichKham.class);
            intent.putExtra("infoUser", appointmentResponse);
            startActivity(intent);
        });
    }

    @Override
    public void onAbortComplete(ResponseJWT responseJWT) {
        if(responseJWT.getMessage().equals("status: 200")){
            Intent intent = new Intent(detailsLichHen.this, DsLich.class);
            startActivity(intent);
        }
    }

    @Override
    public void onAbortError(String message) {

    }
}