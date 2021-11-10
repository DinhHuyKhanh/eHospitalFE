package com.ktt.utils;

public class domain {
    public static String token;
    public static String urlDepartment;
    public static String urlAuth="http://localhost:8080/api/auth/";
    public static String urlDoctor;
    public static String urlAppointment;



    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        domain.token = token;
    }

    public static String getUrlDepartment() {
        return urlDepartment;
    }

    public static void setUrlDepartment(String urlDepartment) {
        domain.urlDepartment = urlDepartment;
    }

    public static String getUrlAuth() {
        return urlAuth;
    }

    public static void setUrlAuth(String urlAuth) {
        domain.urlAuth = urlAuth;
    }

    public static String getUrlDoctor() {
        return urlDoctor;
    }

    public static void setUrlDoctor(String urlDoctor) {
        domain.urlDoctor = urlDoctor;
    }

    public static String getUrlAppointment() {
        return urlAppointment;
    }

    public static void setUrlAppointment(String urlAppointment) {
        domain.urlAppointment = urlAppointment;
    }
}
