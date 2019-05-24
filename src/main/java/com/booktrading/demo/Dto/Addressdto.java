package com.booktrading.demo.Dto;

import com.booktrading.demo.Model.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Addressdto {
    private int addid;
    private String zipcode;
    private String addressdetail;
    private int userid;

    public int getAddid() {
        return addid;
    }

    public void setAddid(int addid) {
        this.addid = addid;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddressdetail() {
        return addressdetail;
    }

    public void setAddressdetail(String addressdetail) {
        this.addressdetail = addressdetail;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Addressdto()
    {

    }
    public Addressdto(Address address)
    {
        this.addid = address.getAddid();
        this.addressdetail = address.getAddressdetail();
        this.zipcode = address.getZipcode();
        this.userid = address.getUser().getUserid();
    }
}
