package com.ktt.response;

import java.io.Serializable;

public class AppointmentResponse implements Serializable {
    private int id;
    private String status;
    private int accountId;
    private int doctorId;
    private String fullName;
    private String birthday;
    private String gender;
    private String address;
    private String numberPhone;
    private String dateAppointment;
    private String department;
    private String degree;
    private int doctorExperience;
    private String doctorName;
    private int doctorPrice;
    private int departmentId;

    public int getDepartmentId() {
        return departmentId;
    }

    public int getId(){
        return this.id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(String dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public String getDepartment() {
        return department;
    }

    public String getDegree() {
        return degree;
    }

    public int getDoctorExperience() {
        return doctorExperience;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public int getDoctorPrice() {
        return doctorPrice;
    }
}
