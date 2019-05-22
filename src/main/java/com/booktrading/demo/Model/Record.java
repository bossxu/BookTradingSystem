package com.booktrading.demo.Model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reid;

    private int userid;
    private int bookid;
    private String address;
    private double bookcost;
    private int solderid;
    private String date;
}
