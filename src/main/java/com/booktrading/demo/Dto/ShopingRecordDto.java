package com.booktrading.demo.Dto;


import com.booktrading.demo.Model.Book;
import com.booktrading.demo.Model.ShopingRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ShopingRecordDto {

    private int shopid;

    private int bookid;
    private int userid;
    private String date;
    private int solderid;
    private Book book;

    public ShopingRecordDto(ShopingRecord shopingRecord)
    {
        this.date = shopingRecord.getDate();
        this.book = shopingRecord.getBook();
        this.shopid = shopingRecord.getShopid();
        this.solderid = shopingRecord.getBook().getUser().getUserid();
    }

    public ShopingRecordDto(){}

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
