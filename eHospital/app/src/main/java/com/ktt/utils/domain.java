package com.ktt.utils;

public class domain {
    public static String token;
    public static String urlDepartment;
<<<<<<< HEAD
    public static String urlAuth="http://192.168.1.5:8080/api/auth/";
=======
    public static String urlAuth="http://192.168.1.121:8080/api/auth/";
>>>>>>> 08ef031c7c08391f564da5fb7f7456a453ae4ced
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
