package com.booktrading.demo.Dao;

import com.booktrading.demo.Model.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordReponsitory extends CrudRepository<Record,Integer> {
}
