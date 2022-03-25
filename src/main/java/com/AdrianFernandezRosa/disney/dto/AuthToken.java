package com.AdrianFernandezRosa.disney.dto;

public class AuthToken {

    private String token;

    public AuthToken(){

    }

    public AuthToken(String token){
        this.token = token;
        System.out.println("mi token"+this.token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}