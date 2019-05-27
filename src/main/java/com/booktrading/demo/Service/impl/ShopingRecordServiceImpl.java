package com.booktrading.demo.Service.impl;

import com.booktrading.demo.Dao.BookReponsitory;
import com.booktrading.demo.Dao.ShopingRecordReponsitory;
import com.booktrading.demo.Dao.UserReponsitory;
import com.booktrading.demo.Dto.ShopingRecordDto;
import com.booktrading.demo.Model.Book;
import com.booktrading.demo.Model.Record;
import com.booktrading.demo.Model.ShopingRecord;
import com.booktrading.demo.Model.User;
import com.booktrading.demo.Service.ShopingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ShopingRecordServiceImpl implements ShopingRecordService {

    @Autowired
    UserReponsitory userReponsitory;
    @Autowired
    ShopingRecordReponsitory shopingRecordReponsitory;
    @Autowired
    BookReponsitory bookReponsitory;
    @Override
    public List<ShopingRecordDto> GetUserShopingRecord(int userid) {
        List<ShopingRecordDto> shopingRecordlist = new ArrayList<>();
        Iterator<ShopingRecord> it = userReponsitory.findById(userid).get().getShopingRecordList().listIterator();
        while(it.hasNext())
        {
            shopingRecordlist.add(new ShopingRecordDto(it.next()));
        }
        return shopingRecordlist;
    }

    @Override
    public String DeleteShopingRecord(int id) {
        shopingRecordReponsitory.deleteById(id);
        return "{\"state\":\"success\"}";
    }

    @Override
    public String SureShopingRecord(int id) {
        return null;
    }

    @Override
    public String CreateShopRecord(ShopingRecordDto shopingRecordDto) {
        Book book = bookReponsitory.findById(shopingRecordDto.getBookid()).get();
        User user = userReponsitory.findById(shopingRecordDto.getUserid()).get();
        ShopingRecord shopingRecord = new ShopingRecord();
        shopingRecord.setBook(book);
        shopingRecord.setUser(user);
        shopingRecordReponsitory.save(shopingRecord);
        return "{\"state\":\"success\"}";
    }
}
