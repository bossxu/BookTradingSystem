package com.booktrading.demo.Dto;

import com.booktrading.demo.Model.User;

public class Userdto {
    private int userid;
    private String authority;
    private String username;
    private double money;
    private String name;
    private String password;
    private String phone;
    private String sex;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Userdto()
    {
        this.authority = "ROLE";
        this.userid = 0;
        this.money = 0.0;
    }
    public Userdto(User user)
    {
        this.money = user.getMoney();
        this.userid = user.getUserid();
        this.authority = user.getAuthority();
        this.name = user.getName();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.sex = user.getSex();
    }
}
