package com.ktt.view;

import com.ktt.response.Department;
import com.ktt.response.Doctor;

import java.util.List;

public interface IDoctorView {
    public void onDoctorComplete(List<Doctor> doctorList);
    public void onDoctorError(String message);
}
