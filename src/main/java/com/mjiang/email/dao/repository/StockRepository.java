package com.mjiang.email.dao.repository;

import com.mjiang.email.model.StockTradeHistory;
import com.mjiang.email.util.DateUtil;
import org.springframework.stereotype.Repository;

import static com.mjiang.email.jooq.domain.Tables.STOCK_TRADE_HISTORY_INFO;

@Repository
public class StockRepository extends BaseRepository {

    public void insertStockTradeHistory(StockTradeHistory stockTradeHistory) {
        /**
         * This set style is preferred way of insert statement
         */
        context.insertInto(STOCK_TRADE_HISTORY_INFO)
               .set(STOCK_TRADE_HISTORY_INFO.BROKER_BUY_STOCK_ID, stockTradeHistory.getStockTableId())
               .set(STOCK_TRADE_HISTORY_INFO.STOCK_CODE, stockTradeHistory.getCode())
               .set(STOCK_TRADE_HISTORY_INFO.START_DATE, DateUtil.localdateToDate(stockTradeHistory.getStartdate()))
               .set(STOCK_TRADE_HISTORY_INFO.TS_DATE, DateUtil.localdateToDate(stockTradeHistory.getDate()))
               .set(STOCK_TRADE_HISTORY_INFO.OPEN_PRICE, stockTradeHistory.getOpen())
               .set(STOCK_TRADE_HISTORY_INFO.CLOSE_PRICE, stockTradeHistory.getClose())
               .set(STOCK_TRADE_HISTORY_INFO.HIGH_PRICE, stockTradeHistory.getHigh())
               .set(STOCK_TRADE_HISTORY_INFO.LOW_PRICE, stockTradeHistory.getLow())
               .set(STOCK_TRADE_HISTORY_INFO.VOLUME, stockTradeHistory.getVolume())
               .execute();
    }
}
