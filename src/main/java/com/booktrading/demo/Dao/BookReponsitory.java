package com.booktrading.demo.Dao;

import com.booktrading.demo.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookReponsitory extends CrudRepository<Book,Integer> {
}
