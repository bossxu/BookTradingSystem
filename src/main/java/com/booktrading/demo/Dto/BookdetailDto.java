package com.booktrading.demo.Dto;


import com.booktrading.demo.Model.Book;
import com.booktrading.demo.Model.Tag;
import com.booktrading.demo.Model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class BookdetailDto {

    private int bookid;
    private float cost;
    private float normalcost;
    private String title;
    private String description;
    private String image;

    @JsonIgnoreProperties({"authority","money","username"})
    private User user;
    private List<Tag> tagList;

    public BookdetailDto(Book book)
    {
        this.bookid = book.getBookid();
        this.cost = book.getCost();
        this.description = book.getDescription();
        this.image = book.getImage();
        this.normalcost = book.getNormalcost();
        this.title = book.getTitle();

        this.user = book.getUser();
        this.tagList = book.getTagList();
    }

}
