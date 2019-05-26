package com.booktrading.demo.Service.impl;

import com.booktrading.demo.Dao.BookReponsitory;
import com.booktrading.demo.Dao.TagReponsitory;
import com.booktrading.demo.Dao.UserReponsitory;
import com.booktrading.demo.Dto.BookDto;
import com.booktrading.demo.Model.Book;
import com.booktrading.demo.Model.Tag;
import com.booktrading.demo.Model.User;
import com.booktrading.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookReponsitory bookReponsitory;

    @Autowired
    UserReponsitory userReponsitory;

    @Autowired
    TagReponsitory tagReponsitory;

    @Override
    public List<Book> GetallBook() {
        List<Book> bookList = new ArrayList<>();
        Iterator<Book> it = bookReponsitory.findAll().iterator();
        while(it.hasNext())
        {
            bookList.add(it.next());
        }
        return bookList;
    }

    @Override
    public String CreateNewBook(BookDto bookDto) {
        User user = userReponsitory.findById(bookDto.getSolder()).get();
        Book book = new Book(bookDto);
        Iterator<String> it = bookDto.getTaglist().listIterator();
        book.setUser(user);
        bookReponsitory.save(book);
        while(it.hasNext())
        {
            String tagname = it.next();
            if(tagReponsitory.existsByTagname(tagname))
            {
               Tag tag = tagReponsitory.findByTagname(tagname);
               tag.addBook(book);
               tagReponsitory.save(tag);
            }
            else
            {
                Tag tag = new Tag(tagname);
                tag.addBook(book);
                tagReponsitory.save(tag);
            }
        }
        return "{\"state\":\"success\"}";
    }

}
