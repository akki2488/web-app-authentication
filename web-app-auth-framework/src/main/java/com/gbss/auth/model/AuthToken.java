package com.gbss.auth.model;

/**
 * Created by Akshay Misra on 15-11-2018.
 */
public class AuthToken {

    private String token;

    public AuthToken(){

    }

    public AuthToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
