package com.booktrading.demo.Dao;

import com.booktrading.demo.Model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressReponsitory extends CrudRepository<Address,Integer> {
}
