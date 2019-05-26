package com.booktrading.demo.Model;

import com.booktrading.demo.Dto.Addressdto;
import lombok.Data;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addid;
    private String zipcode;
    private String addressdetail;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "user_id")
    private User user;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getAddid() {
        return addid;
    }

    public void setAddid(int addid) {
        this.addid = addid;
    }

    public String getAddressdetail() {
        return addressdetail;
    }

    public void setAddressdetail(String addressdetail) {
        this.addressdetail = addressdetail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address(){addid = 0;}

    public Address(Addressdto addressdto)
    {
        this.zipcode = addressdto.getZipcode();
        this.addid = 0;
        this.addressdetail = addressdto.getAddressdetail();
    }
}
