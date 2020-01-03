package com.mjiang.email.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.mjiang.email.model.SmartWatchAllStock;
import com.mjiang.email.model.StockSmartWatchResponse;
import com.mjiang.email.model.StockSmartWatchVO;
import org.joda.time.LocalDateTime;

import static com.mjiang.email.util.DateUtil.SHANGHAI_TZ;

public class StockSmartWatchUtil {

    /**
     * "tm": 140348,
     * "c": "300480",
     * "m": 0,
     * "n": "光力科技",
     * "t": 8204,
     * "i": "-0.031983"
     */
    public static List<StockSmartWatchVO> convertToStockSmartWatchVOList(String json) {
        List<StockSmartWatchVO> stockSmartWatchVOList = new ArrayList<>();

        StockSmartWatchResponse smartWatchResponse = JsonUtil.convertToObject(json, StockSmartWatchResponse.class);
        List<SmartWatchAllStock> smartWatchAllStockList = smartWatchResponse.getData().getAllstock();

        for (SmartWatchAllStock stock : smartWatchAllStockList) {
            StockSmartWatchVO smartWatchVO = new StockSmartWatchVO();
            smartWatchVO.setStockCode(stock.getC());
            smartWatchVO.setStockName(stock.getN());
            smartWatchVO.setmType(String.valueOf(stock.getM()));
            String timeString = String.valueOf(stock.getTm());
            if (timeString != null && timeString.length() == 5) {
                timeString = "0" + timeString;
            }
            LocalDateTime localDateTime = DateUtil.timeToCurrentLocalDateTime(timeString);
            smartWatchVO.setDateTime(localDateTime);
            smartWatchVO.setTypeCode(String.valueOf(stock.getT()));
            smartWatchVO.setInformation(new BigDecimal(stock.getI()));

            stockSmartWatchVOList.add(smartWatchVO);
        }

        return stockSmartWatchVOList;
    }
}
