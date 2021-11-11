package com.ktt.ehospital;

public class LichKham {
    String tenBN;
    String sdtBN;
    String tenBS;
    String khoaKham;
    String ngayKham;
    String gioKham;
    String giaKham;
    String status;

    public LichKham(String tenBN, String sdtBN, String tenBS, String khoaKham, String ngayKham, String gioKham, String giaKham) {
        this.tenBN = tenBN;
        this.sdtBN = sdtBN;
        this.tenBS = tenBS;
        this.khoaKham = khoaKham;
        this.ngayKham = ngayKham;
        this.gioKham = gioKham;
        this.giaKham = giaKham;
    }

    public LichKham(String tenBN, String sdtBN, String tenBS, String khoaKham, String ngayKham, String gioKham, String giaKham, String status) {
        this.tenBN = tenBN;
        this.sdtBN = sdtBN;
        this.tenBS = tenBS;
        this.khoaKham = khoaKham;
        this.ngayKham = ngayKham;
        this.gioKham = gioKham;
        this.giaKham = giaKham;
        this.status = status;
    }

    public String getTenBN() {
        return tenBN;
    }

    public void setTenBN(String tenBN) {
        this.tenBN = tenBN;
    }

    public String getSdtBN() {
        return sdtBN;
    }

    public void setSdtBN(String sdtBN) {
        this.sdtBN = sdtBN;
    }

    public String getTenBS() {
        return tenBS;
    }

    public void setTenBS(String tenBS) {
        this.tenBS = tenBS;
    }

    public String getKhoaKham() {
        return khoaKham;
    }

    public void setKhoaKham(String khoaKham) {
        this.khoaKham = khoaKham;
    }

    public String getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(String ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getGioKham() {
        return gioKham;
    }

    public void setGioKham(String gioKham) {
        this.gioKham = gioKham;
    }

    public String getGiaKham() {
        return giaKham;
    }

    public void setGiaKham(String giaKham) {
        this.giaKham = giaKham;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
