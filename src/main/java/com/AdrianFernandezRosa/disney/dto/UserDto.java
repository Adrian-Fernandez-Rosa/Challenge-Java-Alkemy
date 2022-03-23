package com.AdrianFernandezRosa.disney.dto;


import com.AdrianFernandezRosa.disney.entities.User;

public class UserDto {

    private String email;
    private String password;
    private String nombreCompleto;


    public UserDto() {
    }

    public UserDto(String email, String password, String nombreCompleto) {
        this.email = email;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    public User getUserFromDto(){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setNombreCompleto(nombreCompleto);

        return user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}