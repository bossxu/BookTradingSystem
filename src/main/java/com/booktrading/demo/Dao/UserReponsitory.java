package com.booktrading.demo.Dao;

import com.booktrading.demo.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserReponsitory extends CrudRepository<User,Integer> {

    public User findByUsername(String username);

    public boolean existsByUsername(String username);
}
