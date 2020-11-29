package com.example.kkshop.Po;

import org.litepal.crud.LitePalSupport;

public  class User extends LitePalSupport {

    private int id;
    private String name;
    private String password;

    private String phone;
    private String iccard;
    private String Email;
//    private List<Order> orders;

    public User() {
    }
    public User(String name, String password, String phone, String iccard, String email) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.iccard = iccard;
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
