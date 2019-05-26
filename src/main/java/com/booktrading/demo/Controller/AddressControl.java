package com.booktrading.demo.Controller;


import com.booktrading.demo.Dto.Addressdto;
import com.booktrading.demo.Model.Address;
import com.booktrading.demo.Service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RequestMapping(value = "/api/user/address")
@RestController
@EnableAutoConfiguration
public class AddressControl {

    @Autowired
    AddressServiceImpl addressService;

    @GetMapping("/{id}")
    public List<Address> GetAllAdress(@PathVariable int id)
    {
        return addressService.GetallAddressbyuserid(id);
    }

    @PostMapping("/create")
    public String Addadress(@RequestBody Addressdto addressdto)
    {
        return addressService.addAddress(addressdto);
    }
}
