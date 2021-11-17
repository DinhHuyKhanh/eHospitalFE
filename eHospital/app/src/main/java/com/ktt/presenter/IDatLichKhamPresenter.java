package com.ktt.presenter;

import com.ktt.request.AccountRequest;
import com.ktt.request.AppointmentRequest;

public interface IDatLichKhamPresenter {

    void sendDepartment();
    void sendDoctorByDepartmentId(int id);

    void sendCreateAppointment(AppointmentRequest appointmentRequest, String token);

}
