/*
 * This file is generated by jOOQ.
*/
package com.mjiang.email.jooq.domain;


import com.mjiang.email.jooq.domain.tables.BrokerBuyStockInfo;
import com.mjiang.email.jooq.domain.tables.BrokerBuySummary;
import com.mjiang.email.jooq.domain.tables.DragonTigerStock;
import com.mjiang.email.jooq.domain.tables.PublicHoliday;
import com.mjiang.email.jooq.domain.tables.SmartWatchRef;
import com.mjiang.email.jooq.domain.tables.StockInfoBack;
import com.mjiang.email.jooq.domain.tables.StockInfoFront;
import com.mjiang.email.jooq.domain.tables.StockInfoNo;
import com.mjiang.email.jooq.domain.tables.StockSmartWatch;
import com.mjiang.email.jooq.domain.tables.StockTradeHistoryInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tushare extends SchemaImpl {

    private static final long serialVersionUID = -1185095204;

    /**
     * The reference instance of <code>tushare</code>
     */
    public static final Tushare TUSHARE = new Tushare();

    /**
     * The table <code>tushare.broker_buy_stock_info</code>.
     */
    public final BrokerBuyStockInfo BROKER_BUY_STOCK_INFO = com.mjiang.email.jooq.domain.tables.BrokerBuyStockInfo.BROKER_BUY_STOCK_INFO;

    /**
     * The table <code>tushare.broker_buy_summary</code>.
     */
    public final BrokerBuySummary BROKER_BUY_SUMMARY = com.mjiang.email.jooq.domain.tables.BrokerBuySummary.BROKER_BUY_SUMMARY;

    /**
     * The table <code>tushare.dragon_tiger_stock</code>.
     */
    public final DragonTigerStock DRAGON_TIGER_STOCK = com.mjiang.email.jooq.domain.tables.DragonTigerStock.DRAGON_TIGER_STOCK;

    /**
     * The table <code>tushare.public_holiday</code>.
     */
    public final PublicHoliday PUBLIC_HOLIDAY = com.mjiang.email.jooq.domain.tables.PublicHoliday.PUBLIC_HOLIDAY;

    /**
     * The table <code>tushare.smart_watch_ref</code>.
     */
    public final SmartWatchRef SMART_WATCH_REF = com.mjiang.email.jooq.domain.tables.SmartWatchRef.SMART_WATCH_REF;

    /**
     * The table <code>tushare.stock_info_back</code>.
     */
    public final StockInfoBack STOCK_INFO_BACK = com.mjiang.email.jooq.domain.tables.StockInfoBack.STOCK_INFO_BACK;

    /**
     * The table <code>tushare.stock_info_front</code>.
     */
    public final StockInfoFront STOCK_INFO_FRONT = com.mjiang.email.jooq.domain.tables.StockInfoFront.STOCK_INFO_FRONT;

    /**
     * The table <code>tushare.stock_info_no</code>.
     */
    public final StockInfoNo STOCK_INFO_NO = com.mjiang.email.jooq.domain.tables.StockInfoNo.STOCK_INFO_NO;

    /**
     * The table <code>tushare.stock_smart_watch</code>.
     */
    public final StockSmartWatch STOCK_SMART_WATCH = com.mjiang.email.jooq.domain.tables.StockSmartWatch.STOCK_SMART_WATCH;

    /**
     * The table <code>tushare.stock_trade_history_info</code>.
     */
    public final StockTradeHistoryInfo STOCK_TRADE_HISTORY_INFO = com.mjiang.email.jooq.domain.tables.StockTradeHistoryInfo.STOCK_TRADE_HISTORY_INFO;

    /**
     * No further instances allowed
     */
    private Tushare() {
        super("tushare", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            BrokerBuyStockInfo.BROKER_BUY_STOCK_INFO,
            BrokerBuySummary.BROKER_BUY_SUMMARY,
            DragonTigerStock.DRAGON_TIGER_STOCK,
            PublicHoliday.PUBLIC_HOLIDAY,
            SmartWatchRef.SMART_WATCH_REF,
            StockInfoBack.STOCK_INFO_BACK,
            StockInfoFront.STOCK_INFO_FRONT,
            StockInfoNo.STOCK_INFO_NO,
            StockSmartWatch.STOCK_SMART_WATCH,
            StockTradeHistoryInfo.STOCK_TRADE_HISTORY_INFO);
    }
}
