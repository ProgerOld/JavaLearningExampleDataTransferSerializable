package com.example.javalearningexampledatatransferserializable;

import java.io.Serializable;

public class User implements Serializable {

    //Поля сущности
    private String name; //поле хранения имени
    private String address; //поле хранения адреса
    private String email; //поле хранения почты

    //Необходимый конструктор
    public User(String name, String address, String email){
        this.name = name;
        this.address = address;
        this.email = email;
    }

    //Геттеры и сеттере

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
