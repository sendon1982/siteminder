package com.mjiang.email.dao.repository;

import java.sql.Timestamp;

import com.mjiang.email.model.StockSmartWatchVO;
import com.mjiang.email.model.StockTradeData;
import com.mjiang.email.util.DateUtil;
import org.springframework.stereotype.Repository;

import static com.mjiang.email.jooq.domain.Tables.STOCK_SMART_WATCH;
import static com.mjiang.email.jooq.domain.Tables.STOCK_TRADE_HISTORY_INFO;

@Repository
public class StockRepository extends BaseRepository {

    public void insertStockTradeHistory(StockTradeData stockTradeData) {
        /**
         * This set style is preferred way of insert statement
         */
        context.insertInto(STOCK_TRADE_HISTORY_INFO)
               .set(STOCK_TRADE_HISTORY_INFO.STOCK_CODE, stockTradeData.getCode())
               .set(STOCK_TRADE_HISTORY_INFO.TS_DATE, DateUtil.localDateToDate(stockTradeData.getDate()))
               .set(STOCK_TRADE_HISTORY_INFO.OPEN_PRICE, stockTradeData.getOpenPrice())
               .set(STOCK_TRADE_HISTORY_INFO.CLOSE_PRICE, stockTradeData.getClosePrice())
               .set(STOCK_TRADE_HISTORY_INFO.HIGH_PRICE, stockTradeData.getHighPrice())
               .set(STOCK_TRADE_HISTORY_INFO.LOW_PRICE, stockTradeData.getLowPrice())
               .set(STOCK_TRADE_HISTORY_INFO.VOLUME, stockTradeData.getVolume())
               .execute();
    }

    public void insertStockSmartWatch(StockSmartWatchVO smartWatchVO) {

        context.insertInto(STOCK_SMART_WATCH,
                    STOCK_SMART_WATCH.STOCK_CODE,
                    STOCK_SMART_WATCH.STOCK_NAME,
                    STOCK_SMART_WATCH.M_TYPE,
                    STOCK_SMART_WATCH.DATE_TIME,
                    STOCK_SMART_WATCH.TYPE_CODE,
                    STOCK_SMART_WATCH.INFORMATION)
               .values(
                    smartWatchVO.getStockCode(),
                    smartWatchVO.getStockName(),
                    smartWatchVO.getmType(),
                    new Timestamp(smartWatchVO.getDateTime().toDateTime(DateUtil.SHANGHAI_TZ).getMillis()),
                    smartWatchVO.getTypeCode(),
                    smartWatchVO.getInformation())
               .execute();
    }
}
