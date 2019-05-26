package com.booktrading.demo.Dao;

import com.booktrading.demo.Model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookReponsitory extends CrudRepository<Book,Integer> {

    @Query(value = "select * from book b where (b.description like  CONCAT('%',?1,'%'))  or(b.title like  CONCAT('%',?1,'%'))",nativeQuery = true
    )
    List<Book> GetboosBykeyword(String keyword);
}
