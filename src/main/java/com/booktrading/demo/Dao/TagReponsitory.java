package com.booktrading.demo.Dao;

import com.booktrading.demo.Model.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagReponsitory extends CrudRepository<Tag,Integer> {
    boolean existsByTagname(String tagname);

    Tag findByTagname(String tagname);
}
