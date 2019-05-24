package com.booktrading.demo.Model;

import com.booktrading.demo.Dto.TagDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagid;

    private String tagname;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "book_tag",joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Book> bookList;

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Tag()
    {
        this.bookList = new ArrayList<>();
    }

    public Tag(TagDto tagDto)
    {
        this.tagid = 0;
        this.tagname = tagDto.getTagname();
        this.bookList = new ArrayList<>();
    }
}
