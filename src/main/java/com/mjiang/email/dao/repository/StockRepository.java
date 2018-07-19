package com.mjiang.email.dao.repository;

import com.mjiang.email.model.StockTradeData;
import com.mjiang.email.util.DateUtil;
import org.springframework.stereotype.Repository;

import static com.mjiang.email.jooq.domain.Tables.STOCK_TRADE_HISTORY_INFO;

@Repository
public class StockRepository extends BaseRepository {

    public void insertStockTradeHistory(StockTradeData stockTradeData) {
        /**
         * This set style is preferred way of insert statement
         */
        context.insertInto(STOCK_TRADE_HISTORY_INFO)
               .set(STOCK_TRADE_HISTORY_INFO.STOCK_CODE, stockTradeData.getCode())
               .set(STOCK_TRADE_HISTORY_INFO.TS_DATE, DateUtil.localdateToDate(stockTradeData.getDate()))
               .set(STOCK_TRADE_HISTORY_INFO.OPEN_PRICE, stockTradeData.getOpenPrice())
               .set(STOCK_TRADE_HISTORY_INFO.CLOSE_PRICE, stockTradeData.getClosePrice())
               .set(STOCK_TRADE_HISTORY_INFO.HIGH_PRICE, stockTradeData.getHighPrice())
               .set(STOCK_TRADE_HISTORY_INFO.LOW_PRICE, stockTradeData.getLowPrice())
               .set(STOCK_TRADE_HISTORY_INFO.VOLUME, stockTradeData.getVolume())
               .execute();
    }
}
