package com.booktrading.demo.Controller;


import com.booktrading.demo.Dto.BookDto;
import com.booktrading.demo.Dto.BookQueryDto;
import com.booktrading.demo.Dto.BookdetailDto;
import com.booktrading.demo.Model.Book;
import com.booktrading.demo.Service.BookService;
import com.booktrading.demo.Service.TagService;
import com.booktrading.demo.Service.impl.BookServiceImpl;
import com.booktrading.demo.Service.impl.TagServiceImpl;
import com.booktrading.demo.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/book")
public class BookControl {

    @Autowired
    BookServiceImpl bookService;
    @Autowired
    TagServiceImpl tagService;
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/all")
    public List<Book> Getallbooks()
    {
        return bookService.GetallBook();
    }

    @GetMapping("/{id}")
    public BookdetailDto GetBookdetail(@PathVariable int id)
    {
        return new BookdetailDto(bookService.getbookdetail(id));
    }

    @PostMapping("/create")
    public String CreatenewBook(@RequestBody BookDto bookDto)
    {
        return bookService.CreateNewBook(bookDto);
    }

    @GetMapping("/tag/{id}")
    public List<Book> Getallboosbytag(@PathVariable int id)
    {
        return tagService.GetbooksbyTag(id);
    }

    @GetMapping("/user/{id}")
    public List<Book> Getallbooksbyuser(@PathVariable int id)
    {
        return userService.GetAllbooksbuy(id);
    }

    @GetMapping("/search")
    public List<Book> Getbooksbusearch(@RequestBody BookQueryDto bookQueryDto)
    {
        return bookService.GetBooksbuSearch(bookQueryDto);
    }
}
