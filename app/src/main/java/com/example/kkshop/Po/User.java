package com.example.kkshop.Po;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

public  class User extends LitePalSupport {

    private int id;
    private String name;
    private String password;

    private String phone;
    private String iccard;
    private String Email;

    public User() {
    }

    public User(String name, String password, String phone, String Iccard, String email) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.iccard = Iccard;
        Email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIccard() {
        return iccard;
    }

    public void setIccard(String iccard) {
        this.iccard = iccard;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
