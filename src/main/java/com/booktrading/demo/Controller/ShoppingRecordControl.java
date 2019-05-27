package com.booktrading.demo.Controller;

import com.booktrading.demo.Dao.ShopingRecordReponsitory;
import com.booktrading.demo.Dto.ShopingRecordDto;
import com.booktrading.demo.Service.ShopingRecordService;
import com.booktrading.demo.Service.impl.ShopingRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/shop")
public class ShoppingRecordControl {

    @Autowired
    ShopingRecordServiceImpl shopingRecordService;


    @PostMapping("/create")
    public String CreateNewShopingrecord(@RequestBody ShopingRecordDto shopingRecordDto)
    {
        return shopingRecordService.CreateShopRecord(shopingRecordDto);
    }

    @GetMapping("/user/{id}")
    public List<ShopingRecordDto> Getshopinglistbyuserid(@PathVariable int id)
    {
        return shopingRecordService.GetUserShopingRecord(id);
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteShopingrecord(@PathVariable int id)
    {
        return shopingRecordService.DeleteShopingRecord(id);
    }
}
