package com.booktrading.demo.Service.impl;

import com.booktrading.demo.Dao.BookReponsitory;
import com.booktrading.demo.Dao.RecordReponsitory;
import com.booktrading.demo.Dao.UserReponsitory;
import com.booktrading.demo.Dto.RecordDto;
import com.booktrading.demo.Model.Book;
import com.booktrading.demo.Model.Record;
import com.booktrading.demo.Model.User;
import com.booktrading.demo.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    UserReponsitory userReponsitory;
    @Autowired
    RecordReponsitory recordReponsitory;
    @Autowired
    BookReponsitory bookReponsitory;

    @Override
    public String AddRecord(RecordDto recordDto) {
        User buyer = userReponsitory.findById(recordDto.getBuyid()).get();
        User solder = userReponsitory.findById(recordDto.getSolderid()).get();
        Record record = new Record(recordDto);
        Book book = bookReponsitory.findById(recordDto.getBookid()).get();
        if(book.isSoldenable() == true)
        {
            return "{\"state\":\"error\",\"info\":\"已经被买走了\"}";
        }
        if(recordDto.getBuyid() == recordDto.getSolderid())
        {
            return "{\"state\":\"error\",\"info\":\"不能买自己的书\"}";
        }
        if(buyer.getMoney() < book.getCost())
        {
            return "{\"state\":\"error\",\"info\":\"钱不够啊\"}";
        }
        buyer.setMoney(buyer.getMoney()-book.getCost());
        record.setUser(buyer);
        record.setSolder(solder);
        book.setSoldenable(true);
        book.setTagList(new ArrayList<>());
        userReponsitory.save(buyer);
        recordReponsitory.save(record);
        bookReponsitory.save(book);
        return "{\"state\":\"success\"}";
    }

    public String RecordForsure(RecordDto recordDto)
    {
        User buyer = userReponsitory.findById(recordDto.getSolderid()).get();
        Book book = bookReponsitory.findById(recordDto.getBookid()).get();
        Record record = recordReponsitory.findById(recordDto.getReid()).get();
        if(record.isForsure())
        {
            return "{\"state\":\"error\",\"response\":\"已经确认过订单了\"}";
        }
        buyer.setMoney(buyer.getMoney()+book.getCost());
        userReponsitory.save(buyer);
        record.setForsure(true);
        recordReponsitory.save(record);
        return "{\"state\":\"success\"}";
    }
}
