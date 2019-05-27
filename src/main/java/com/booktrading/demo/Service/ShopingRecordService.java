package com.booktrading.demo.Service;

import com.booktrading.demo.Dto.ShopingRecordDto;
import com.booktrading.demo.Model.ShopingRecord;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

public interface ShopingRecordService {

    public List<ShopingRecordDto> GetUserShopingRecord(int userid);

    public String DeleteShopingRecord(int id);

    public String SureShopingRecord(int id);

    public String CreateShopRecord(ShopingRecordDto shopingRecordDto);
}
