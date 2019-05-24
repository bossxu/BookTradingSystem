package com.booktrading.demo.Dto;

import com.booktrading.demo.Model.MoneyRecord;

public class MoneyRecordDto {

    private int id;
    private String date;
    private double money;
    private String username;
    private String behavior;

    public MoneyRecordDto()
    {
        int id = 0;
    }
    public MoneyRecordDto(MoneyRecord moneyRecord)
    {
        this.id = moneyRecord.getId();
        this.date = moneyRecord.getDate();
        this.money = moneyRecord.getMoney();
        this.username = moneyRecord.getUser().getName();
        if(this.money >=0)
        {
            this.behavior = "充钱";
        }
        else
        {
            this.behavior = "提现";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
}
