package com.ktt.view;

import com.ktt.request.AppointmentRequest;
import com.ktt.response.Department;
import com.ktt.response.Doctor;
import com.ktt.response.ResponseJWT;

import java.util.List;

public interface IDatLichHenView {
    public void onDepartmentComplete(List<Department> departmentList);
    public void onDepartmentError(String message);

    public void onDoctorComplete(List<Doctor> doctorList);
    public void onDoctorError(String message);

    public void onCreateAppointmentComplete(ResponseJWT responseJWT);
    public void onAppointmentError(String message);

    public void onUpdateAppointmentComplete(ResponseJWT responseJWT);
    public void onUpdateAppointmentError(String message);

}
