package com.example.kkshop.Po;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;

/**
 *  测试版SHA1: 3F:3B:F6:3A:2A:BD:77:C3:90:D0:0F:DA:DB:FF:FA:BE:B1:7A:55:4E
 *
 * AK:jO5xGlBoI4nCZ8dzFbsrMgzMrqc4qxFc
 */
public class DeliverLocation extends LitePalSupport implements Serializable {

    /**
     * District 区
     * Street  街道
     */
    private int Id;
    private String name;
    private String phone;
    private int isdefault;
    private String Country;
    private String Province;
    private String City;
    private String District;
    private String Street;
    private String DetailedAddress;
    private int user_id;

    public DeliverLocation() {
    }

    public DeliverLocation(int id, String name, String phone, int isdefault, String country, String province, String city, String district, String street, String detailedAddress, int user_id) {
        Id = id;
        this.name = name;
        this.phone = phone;
        this.isdefault = isdefault;
        Country = country;
        Province = province;
        City = city;
        District = district;
        Street = street;
        DetailedAddress = detailedAddress;
        this.user_id = user_id;
    }

    public int getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(int isdefault) {
        this.isdefault = isdefault;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getDetailedAddress() {
        return DetailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        DetailedAddress = detailedAddress;
    }
}

