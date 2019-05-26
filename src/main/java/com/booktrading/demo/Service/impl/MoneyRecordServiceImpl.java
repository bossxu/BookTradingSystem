package com.booktrading.demo.Service.impl;

import com.booktrading.demo.Dao.MoneyRecordReponsitory;
import com.booktrading.demo.Dao.UserReponsitory;
import com.booktrading.demo.Dto.MoneyRecordDto;
import com.booktrading.demo.Model.MoneyRecord;
import com.booktrading.demo.Model.User;
import com.booktrading.demo.Service.MoneyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class MoneyRecordServiceImpl implements MoneyRecordService {

    @Autowired
    MoneyRecordReponsitory moneyRecordReponsitory;

    @Autowired
    UserReponsitory userReponsitory;

    @Override
    public List<MoneyRecord> GetAllMoneyRecord() {
        List<MoneyRecord> moneyRecordList = new ArrayList<>();
        Iterator<MoneyRecord> it = moneyRecordReponsitory.findAll().iterator();
        while(it.hasNext())
        {
            moneyRecordList.add(it.next());
        }
        return moneyRecordList;
    }

    @Override
    public List<MoneyRecord> GetMoneyRecordsbyUerid(int userid) {
        List<MoneyRecord> moneyRecordList = new ArrayList<>();
        Iterator<MoneyRecord> it = moneyRecordReponsitory.findAllByUser(userid).iterator();
        while(it.hasNext())
        {
            moneyRecordList.add(it.next());
        }
        return moneyRecordList;
    }

    @Override
    public String CreateNewMoneyRecord(MoneyRecordDto moneyRecordDto) {
        MoneyRecord moneyRecord = new MoneyRecord();
        moneyRecordReponsitory.save(moneyRecord);
        User user = userReponsitory.findByUsername(moneyRecordDto.getUsername());
        user.setMoney(user.getMoney()+moneyRecordDto.getMoney());
        user.addMoneyRecord(moneyRecord);
        userReponsitory.save(user);
        return "{\"state\":\"success\"}";
    }

    @Override
    public void DeleteMoneyRecord(int id) {
        moneyRecordReponsitory.deleteById(id);
    }
}
