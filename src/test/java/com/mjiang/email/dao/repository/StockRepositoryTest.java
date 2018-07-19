package com.mjiang.email.dao.repository;

import java.math.BigDecimal;

import com.mjiang.email.model.StockTradeData;
import org.joda.time.LocalDate;
import org.junit.Ignore;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Tag("ManualTest")
@Ignore
class StockRepositoryTest extends BaseRepositoryTest {

    @Autowired
    StockRepository stockRepository;

    @Test
    void test_insertStockTradeHistory() {
        StockTradeData stockTradeData = new StockTradeData();

        stockTradeData.setCode("002927");
        stockTradeData.setDate(LocalDate.parse("2018-07-06"));
        stockTradeData.setOpenPrice(new BigDecimal(39.0));
        stockTradeData.setClosePrice(new BigDecimal(39.18));
        stockTradeData.setHighPrice(new BigDecimal(39.18));
        stockTradeData.setLowPrice(new BigDecimal(39.0));
        stockTradeData.setVolume(new BigDecimal(41663.0));

        stockRepository.insertStockTradeHistory(stockTradeData);
    }
}