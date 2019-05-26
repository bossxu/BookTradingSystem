package com.booktrading.demo.Dao;

import com.booktrading.demo.Model.MoneyRecord;
import com.booktrading.demo.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoneyRecordReponsitory extends CrudRepository<MoneyRecord,Integer> {

    List<MoneyRecord> findAllByUser(User user);
}
