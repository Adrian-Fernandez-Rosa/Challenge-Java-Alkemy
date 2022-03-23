package com.AdrianFernandezRosa.disney.dto;


import com.AdrianFernandezRosa.disney.entities.User;

//los dto no llevan anotaciones
public class UserDto {

    private String email;
    private String password;
    private String name;


    public UserDto() {
    }

    public User getUserFromDto(){
        User user = new User();

        user.setPassword(password);
        user.setEmail(email);
        user.setNombreCompleto(name);


        
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}