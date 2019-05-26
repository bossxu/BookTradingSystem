package com.booktrading.demo.Model;


import com.booktrading.demo.Dto.RecordDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reid;

    private int bookid;
    private String address;
    private double bookcost;
    private boolean forsure;
    private String date;

    @JsonIgnoreProperties({"authority","money","username"})
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnoreProperties({"authority","money","username"})
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "sold_id")
    private User solder;

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBookcost() {
        return bookcost;
    }

    public void setBookcost(double bookcost) {
        this.bookcost = bookcost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getSolder() {
        return solder;
    }

    public void setSolder(User solder) {
        this.solder = solder;
    }

    public boolean isForsure() {
        return forsure;
    }

    public void setForsure(boolean forsure) {
        this.forsure = forsure;
    }

    public Record(){
        this.reid = 0;
    }
    public Record(RecordDto recordDto)
    {
        this.reid = 0;
        this.forsure = false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = df.format(new Date());

        this.address = recordDto.getAddress();
        this.bookcost = recordDto.getBookcost();
        this.bookid = recordDto.getBookid();
    }

    @Override
    public String toString() {
        return "{" +
                "reid:" + reid +
                ", bookid:" + bookid +
                ", address:'" + address + '\'' +
                ", bookcost:" + bookcost +
                ", forsure:" + forsure +
                ", date:'" + date + '\'' +
                ", buyer:'" + user.getUsername() + '\'' +
                ", date:'" + date + '\'' +
                '}';
    }
}
