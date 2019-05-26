package com.booktrading.demo.Service.impl;

import com.booktrading.demo.Dao.TagReponsitory;
import com.booktrading.demo.Dto.TagDto;
import com.booktrading.demo.Model.Book;
import com.booktrading.demo.Model.Tag;
import com.booktrading.demo.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagReponsitory tagReponsitory;

    @Override
    public List<Tag> GetAlltag() {
        List<Tag> tagList = new ArrayList<>();
        Iterator<Tag> it = tagReponsitory.findAll().iterator();
        while(it.hasNext())
        {
            tagList.add(it.next());
        }
        return tagList;
    }

    @Override
    public String CreateNeaTag(TagDto tagDto) {
        Tag a = new Tag(tagDto);
        System.out.println(a.toString()+tagDto.getTagname());
        tagReponsitory.save(a);
        return "{\"state\":\"success\"}";
    }

    @Override
    public String deleteTag(int tagid) {
        tagReponsitory.deleteById(tagid);
        return "{\"state\":\"success\"}";
    }

    @Override
    public List<Book> GetbooksbyTag(int tagid) {
        return tagReponsitory.findById(tagid).get().getBookList();
    }
}
