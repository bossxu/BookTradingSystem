package com.booktrading.demo.Controller;


import com.booktrading.demo.Dto.RecordDto;
import com.booktrading.demo.Model.Record;
import com.booktrading.demo.Service.impl.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/record")
public class RecordControl {

    @Autowired
    RecordServiceImpl recordService;

    @PostMapping(value = "/create")
    public String AddRecord(RecordDto recordDto)
    {
        return recordService.AddRecord(recordDto);
    }

}
