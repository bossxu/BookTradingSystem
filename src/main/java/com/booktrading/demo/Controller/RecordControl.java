package com.booktrading.demo.Controller;


import com.booktrading.demo.Dao.UserReponsitory;
import com.booktrading.demo.Dto.RecordDto;
import com.booktrading.demo.Model.Record;
import com.booktrading.demo.Service.UserService;
import com.booktrading.demo.Service.impl.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/record")
public class RecordControl {

    @Autowired
    RecordServiceImpl recordService;
    @Autowired
    UserReponsitory userReponsitory;

    @PostMapping(value = "/create")
    public String AddRecord(@RequestBody RecordDto recordDto)
    {
        return recordService.AddRecord(recordDto);
    }

    @PostMapping(value = "/sure")
    public String Forsure(@RequestBody RecordDto recordDto)
    {
        return recordService.RecordForsure(recordDto);
    }

    @GetMapping(value = "/asbuyer/{id}")
    public List<Record> GetRecordsasBuyer(@PathVariable int id)
    {
        return userReponsitory.findById(id).get().getRecordList();
    }
    @GetMapping(value = "/assolder/{id}")
    public List<Record> GetRecordasSolder(@PathVariable int id)
    {
        return userReponsitory.findById(id).get().getRecordAssolderList();
    }

}
