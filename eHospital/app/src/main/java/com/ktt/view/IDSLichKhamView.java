package com.ktt.view;

import com.ktt.response.AppointmentResponse;

import java.util.List;

public interface IDSLichKhamView {
    void onDSLichComplete(List<AppointmentResponse> appointmentResponseList);
    void onDSLichError(String message);
}
