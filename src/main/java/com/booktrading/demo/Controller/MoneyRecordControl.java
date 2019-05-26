package com.booktrading.demo.Controller;


import com.booktrading.demo.Dto.MoneyRecordDto;
import com.booktrading.demo.Model.MoneyRecord;
import com.booktrading.demo.Service.MoneyRecordService;
import com.booktrading.demo.Service.impl.MoneyRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/money")
@EnableAutoConfiguration
@RestController
public class MoneyRecordControl {

    @Autowired
    MoneyRecordServiceImpl moneyRecordService;

    @GetMapping(value = "/{id}")
    public List<MoneyRecord> GetMoneyRecordbyuserid(@PathVariable int userid)
    {
        return moneyRecordService.GetMoneyRecordsbyUerid(userid);
    }

    @PostMapping(value = "/create")
    public String CreateNewRecord(MoneyRecordDto moneyRecordDto)
    {
        return moneyRecordService.CreateNewMoneyRecord(moneyRecordDto);
    }
}
