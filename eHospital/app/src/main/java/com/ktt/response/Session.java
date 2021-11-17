package com.ktt.response;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setUsename(String usename) {
        prefs.edit().putString("usename", usename).commit();
    }

    public String getusename() {
        String usename = prefs.getString("usename","");
        return usename;
    }

    public void setId(int  id) {
        prefs.edit().putInt("id", id).commit();
    }

    public int getId() {
        int id = prefs.getInt("id",0);
        return id;
    }

    public void setAccessToken(String accessToken) {
        prefs.edit().putString("accessToken", accessToken).commit();
    }

    public String getAccessToken() {
        String accessToken = prefs.getString("accessToken","");
        return accessToken;
    }







}
