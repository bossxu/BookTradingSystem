package com.booktrading.demo.Service;

import com.booktrading.demo.Dto.MoneyRecordDto;
import com.booktrading.demo.Dto.RecordDto;
import com.booktrading.demo.Model.Record;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

public interface RecordService {

   String AddRecord(RecordDto recordDto);
   
}
