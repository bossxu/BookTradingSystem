package com.booktrading.demo.Model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookid;
    private float cost;
    private float normalcost;
    private String title;
    private String description;
    private boolean soldenable;
    private String image;
}
