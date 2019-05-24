package com.booktrading.demo.Model;


import com.booktrading.demo.Dto.Userdto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    private String username;
    private String password;
    private String phone;
    private String sex;
    private String name;
    private String authority;
    private double money;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Address> addresseslist;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<MoneyRecord> moneyRecordList;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Book> bookList;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Record> recordList;

    @JsonIgnore
    @OneToMany(mappedBy = "solder",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Record> recordAssolderList;

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

    public List<Record> getRecordAssolderList() {
        return recordAssolderList;
    }

    public void setRecordAssolderList(List<Record> recordAssolderList) {
        this.recordAssolderList = recordAssolderList;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Address> getAddresseslist() {
        return addresseslist;
    }

    public void setAddresseslist(List<Address> addresseslist) {
        this.addresseslist = addresseslist;
    }

    public List<MoneyRecord> getMoneyRecordList() {
        return moneyRecordList;
    }

    public void setMoneyRecordList(List<MoneyRecord> moneyRecordList) {
        this.moneyRecordList = moneyRecordList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public User(){
        userid = 0;
        this.addresseslist = new ArrayList<>();
        this.bookList = new ArrayList<>();
        this.moneyRecordList = new ArrayList<>();
        this.recordAssolderList = new ArrayList<>();
        this.recordList = new ArrayList<>();
    }
    public User(Userdto userdto)
    {
        userid = 0;
        this.money = 0.0;
        this.authority = "ROLE";
        this.addresseslist = new ArrayList<>();
        this.bookList = new ArrayList<>();
        this.moneyRecordList = new ArrayList<>();
        this.recordAssolderList = new ArrayList<>();
        this.recordList = new ArrayList<>();

        this.name = userdto.getName();
        this.username = userdto.getName();
        this.password = userdto.getPassword();
        this.phone = userdto.getPhone();
        this.sex = userdto.getSex();
    }
}
