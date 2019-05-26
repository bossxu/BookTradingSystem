package com.booktrading.demo.Dto;

import com.booktrading.demo.Model.Book;

import java.util.List;

public class BookDto {
    private int bookid;
    private float cost;
    private float normalcost;
    private String title;
    private String description;
    private String image;
    private int solder;
    private List<String> taglist;


    public int getSolder() {
        return solder;
    }

    public void setSolder(int solder) {
        this.solder = solder;
    }

    public List<String> getTaglist() {
        return taglist;
    }

    public void setTaglist(List<String> taglist) {
        this.taglist = taglist;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getNormalcost() {
        return normalcost;
    }

    public void setNormalcost(float normalcost) {
        this.normalcost = normalcost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BookDto()
    {
        this.bookid = 0;
    }
    public BookDto(Book book)
    {
        this.bookid = book.getBookid();
        this.cost = book.getCost();
        this.description = book.getDescription();
        this.normalcost = book.getNormalcost();
        this.image = book.getImage();
        this.title = book.getTitle();
        this.solder = book.getUser().getUserid();
    }
}
