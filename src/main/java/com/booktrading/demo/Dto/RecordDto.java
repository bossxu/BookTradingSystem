package com.booktrading.demo.Dto;

import com.booktrading.demo.Model.Record;

public class RecordDto {

    private int reid;
    private int bookid;
    private String address;
    private double bookcost;
    private int buyid;
    private int solderid;

    public RecordDto()
    {
        this.reid = 0;
    }

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


    public int getBuyid() {
        return buyid;
    }

    public void setBuyid(int buyid) {
        this.buyid = buyid;
    }

    public int getSolderid() {
        return solderid;
    }

    public void setSolderid(int solderid) {
        this.solderid = solderid;
    }
}
