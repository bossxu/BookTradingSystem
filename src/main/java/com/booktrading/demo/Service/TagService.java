package com.booktrading.demo.Service;

import com.booktrading.demo.Dto.TagDto;
import com.booktrading.demo.Model.Book;
import com.booktrading.demo.Model.Tag;

import java.util.List;

public interface TagService {

    public List<Tag> GetAlltag();

    public String CreateNeaTag(TagDto tagDto);

    public String deleteTag(int tagid);

    public List<Book> GetbooksbyTag(int tagid);
}
