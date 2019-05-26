package com.booktrading.demo.Model;


import com.booktrading.demo.Dto.BookDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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

    @JsonIgnore
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToMany(mappedBy = "bookList",fetch = FetchType.LAZY)
    private List<Tag> tagList;

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

    public boolean isSoldenable() {
        return soldenable;
    }

    public void setSoldenable(boolean soldenable) {
        this.soldenable = soldenable;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public Book()
    {
        this.bookid = 0;
        this.soldenable = false;
        this.tagList = new ArrayList<>();
    }

    public Book(BookDto bookDto)
    {
        this.bookid = 0;
        this.soldenable = false;
        this.tagList = new ArrayList<>();

        this.cost = bookDto.getCost();
        this.description = bookDto.getDescription();
        this.image = bookDto.getImage();
        this.normalcost = bookDto.getNormalcost();
        this.title = bookDto.getTitle();

    }

    public void addTag(Tag tag)
    {
        this.tagList.add(tag);
    }
    @Override
    public String toString() {
        return "{" +
                "bookid=" + bookid +
                ", cost=" + cost +
                ", normalcost=" + normalcost +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user='" + user.getUsername() + '\'' +
                ", soldenable=" + soldenable +
                ", image='" + image + '\'' +
                '}';
    }
}
