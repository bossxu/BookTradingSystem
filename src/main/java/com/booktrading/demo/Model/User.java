package com.booktrading.demo.Model;


import lombok.Data;

import javax.persistence.*;

@Data
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
}
