package com.booktrading.demo.Service;

import com.booktrading.demo.Dto.MoneyRecordDto;
import com.booktrading.demo.Model.MoneyRecord;

import java.util.List;

public interface MoneyRecordService {

    List<MoneyRecord> GetAllMoneyRecord();

    List<MoneyRecord> GetMoneyRecordsbyUerid(int userid);

    String CreateNewMoneyRecord(MoneyRecordDto moneyRecordDto);

    void DeleteMoneyRecord(int id);

}
