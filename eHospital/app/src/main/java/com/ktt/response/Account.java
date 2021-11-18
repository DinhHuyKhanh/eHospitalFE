package com.ktt.response;

import java.util.List;

public class Account {
    private int id;
    private String username;
    private List<String> roles;
    private String tokenType;
    private String accessToken;

    public Account(int id, String username, List<String> roles, String tokenType, String accessToken) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.tokenType = tokenType;
        this.accessToken = accessToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
