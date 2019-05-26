package com.booktrading.demo.Service;

import com.booktrading.demo.Dto.BookDto;
import com.booktrading.demo.Dto.BookQueryDto;
import com.booktrading.demo.Model.Book;

import java.util.List;

public interface BookService {

    List<Book> GetallBook();

    String CreateNewBook(BookDto bookDto);

    List<Book> GetBooksbuSearch(BookQueryDto bookQueryDto);

    Book getbookdetail(int id);

}
