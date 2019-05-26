package com.booktrading.demo.Service.impl;

import com.booktrading.demo.Dao.AddressReponsitory;
import com.booktrading.demo.Dao.UserReponsitory;
import com.booktrading.demo.Dto.Addressdto;
import com.booktrading.demo.Model.Address;
import com.booktrading.demo.Model.User;
import com.booktrading.demo.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    UserReponsitory userReponsitory;
    @Autowired
    AddressReponsitory addressReponsitory;


    @Override
    public String addAddress(Addressdto addressdto) {
        User user = userReponsitory.findById(addressdto.getUserid()).get();
        Address address = new Address(addressdto);
        address.setUser(user);
        addressReponsitory.save(address);
        return "{\"state\":\"success\"}";
    }

    @Override
    public List<Address> GetallAddressbyuserid(int userid) {
        User user = userReponsitory.findById(userid).get();
        return user.getAddresseslist();
    }
}
