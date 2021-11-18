package com.ktt.ehospital;

public class LichKham {
    String tenBN;
    String dateAppointment;
    String status;

    public LichKham(String tenBN, String dateAppointment, String status) {
        this.tenBN = tenBN;
        this.dateAppointment=dateAppointment;
        this.status = status;
    }

    public String getTenBN() {
        return tenBN;
    }

    public void setTenBN(String tenBN) {
        this.tenBN = tenBN;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
