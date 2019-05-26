package com.booktrading.demo.Model;

import com.booktrading.demo.Dto.MoneyRecordDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.org.glassfish.gmbal.ManagedAttribute;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class MoneyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double money;
    private String date;

    @JsonIgnore
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "user_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
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
    public MoneyRecord(){}

    public MoneyRecord(MoneyRecordDto moneyRecordDto)
    {
        this.id = 0;
        this.money = moneyRecordDto.getMoney();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = df.format(new Date());
    }
}
