package com.booktrading.demo.Dto;

import com.booktrading.demo.Model.Tag;

public class TagDto {
    private int tagid;
    private String tagname;

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

    public TagDto()
    {
        this.tagid = 0;
    }
    public TagDto(Tag tag)
    {
        this.tagid = tag.getTagid();
        this.tagname = tag.getTagname();
    }
}
