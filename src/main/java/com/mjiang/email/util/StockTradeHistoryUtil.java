package com.mjiang.email.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mjiang.email.model.StockTradeData;
import org.joda.time.LocalDate;

@SuppressWarnings("unchecked")
public class StockTradeHistoryUtil {

    /**
     * "2017-01-03",   date
     * "12.184",       open
     * "12.251",       close
     * "12.356",       high
     * "12.153",       low
     * "162371.000"    volume
     *
     */
    public static List<StockTradeData> convertToStockTradeData(Map<String, Object> map) {
        List<StockTradeData> stockTradeDataList = new ArrayList<>();

        Map<String, Object> dataMap = (Map<String, Object>) map.get("data");

        for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
            String stockCode = entry.getKey();
            Map<String, Object> qfqDayMap = (Map<String, Object>) entry.getValue();

            Object obj = qfqDayMap.get("day");

            if (obj == null) {
                obj = qfqDayMap.get("qfqday");
            }

            List<List<String>> stockDailyList = (List<List<String>>) obj;

            for (List<String> stockDaily: stockDailyList) {
                StockTradeData stockTradeData = new StockTradeData();
                stockTradeData.setCode(stockCode);
                stockTradeData.setDate(LocalDate.parse(stockDaily.get(0)));
                stockTradeData.setOpenPrice(convertToBigDecimal(stockDaily.get(1)));
                stockTradeData.setClosePrice(convertToBigDecimal(stockDaily.get(2)));
                stockTradeData.setHighPrice(convertToBigDecimal(stockDaily.get(3)));
                stockTradeData.setLowPrice(convertToBigDecimal(stockDaily.get(4)));
                stockTradeData.setVolume(convertToBigDecimal(stockDaily.get(5)));
                stockTradeDataList.add(stockTradeData);
            }
        }

        return stockTradeDataList;
    }

    private static BigDecimal convertToBigDecimal(String value) {
        double aDouble = Double.parseDouble(value);
        return BigDecimal.valueOf(aDouble);
    }
}
