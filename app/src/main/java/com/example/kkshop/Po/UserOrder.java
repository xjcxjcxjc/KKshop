package com.example.kkshop.Po;

import org.litepal.crud.LitePalSupport;

public class UserOrder extends LitePalSupport {

    private static final int STATU_NOPAY=1;
    private static final int STATU_NODELIVER=2;
    private static final int STATU_NORECEIVE=3;
    private static final int STATU_NOCOMMENT =4;

    private int price;
    private int Nub;
    private User user;
    //订单的状态
    private int Statu;
    private Goods goods;

    public UserOrder() {
    }

    public UserOrder(int price, int nub, User user, int statu, Goods goods) {
        this.price = price;
        Nub = nub;
        this.user = user;
        Statu = statu;
        this.goods = goods;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatu() {
        return Statu;
    }

    public void setStatu(int statu) {
        Statu = statu;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public void setNub(int nub) {
        Nub = nub;
    }


    public int getPrice() {
        return price;
    }

    public int getNub() {
        return Nub;
    }

}
