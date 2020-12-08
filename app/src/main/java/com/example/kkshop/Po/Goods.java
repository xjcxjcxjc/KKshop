package com.example.kkshop.Po;


import org.litepal.crud.LitePalSupport;

import java.util.List;

public class Goods extends LitePalSupport {

    private int id;
    private String name;
    private int price;
    private String description;
    private int saleNub;
    private String imgUrl;

    public Goods() {
    }

    public Goods(String name, int price, String description, int saleNub, String imgUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.saleNub = saleNub;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSaleNub() {
        return saleNub;
    }

    public void setSaleNub(int saleNub) {
        this.saleNub = saleNub;
    }
}
