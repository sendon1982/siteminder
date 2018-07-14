package com.mjiang.email.dao.repository;

import java.math.BigDecimal;

import com.mjiang.email.model.BrokerPlacedOrder;
import com.mjiang.email.model.StockTradeHistory;
import org.joda.time.LocalDate;
import org.junit.Ignore;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

@Tag("ManualTest")
@Ignore
class StockRepositoryTest extends BaseRepositoryTest {

    @Autowired
    StockRepository stockRepository;

    @Test
    void test_insertStockTradeHistory() {
        StockTradeHistory stockTradeHistory = new StockTradeHistory();

        stockTradeHistory.setStockTableId(90848L);
        stockTradeHistory.setCode("002927");
        stockTradeHistory.setStartdate(LocalDate.parse("2018-07-06"));
        stockTradeHistory.setDate(LocalDate.parse("2018-07-06"));
        stockTradeHistory.setOpen(new BigDecimal(39.0));
        stockTradeHistory.setClose(new BigDecimal(39.18));
        stockTradeHistory.setHigh(new BigDecimal(39.18));
        stockTradeHistory.setLow(new BigDecimal(39.0));
        stockTradeHistory.setVolume(new BigDecimal(41663.0));

        stockRepository.insertStockTradeHistory(stockTradeHistory);
    }
}