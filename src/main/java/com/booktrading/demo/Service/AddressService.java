package com.booktrading.demo.Service;

import com.booktrading.demo.Dto.Addressdto;
import com.booktrading.demo.Model.Address;

import java.util.List;

public interface AddressService {

    public String addAddress(Addressdto addressdto);

    public List<Address> GetallAddressbyuserid(int userid);
}
