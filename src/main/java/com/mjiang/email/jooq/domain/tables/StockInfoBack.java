/*
 * This file is generated by jOOQ.
*/
package com.mjiang.email.jooq.domain.tables;


import com.mjiang.email.jooq.domain.Indexes;
import com.mjiang.email.jooq.domain.Keys;
import com.mjiang.email.jooq.domain.Tushare;
import com.mjiang.email.jooq.domain.tables.records.StockInfoBackRecord;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class StockInfoBack extends TableImpl<StockInfoBackRecord> {

    private static final long serialVersionUID = -195066746;

    /**
     * The reference instance of <code>tushare.stock_info_back</code>
     */
    public static final StockInfoBack STOCK_INFO_BACK = new StockInfoBack();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StockInfoBackRecord> getRecordType() {
        return StockInfoBackRecord.class;
    }

    /**
     * The column <code>tushare.stock_info_back.id</code>.
     */
    public final TableField<StockInfoBackRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>tushare.stock_info_back.stock_code</code>.
     */
    public final TableField<StockInfoBackRecord, String> STOCK_CODE = createField("stock_code", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>tushare.stock_info_back.ts_date</code>.
     */
    public final TableField<StockInfoBackRecord, Date> TS_DATE = createField("ts_date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>tushare.stock_info_back.open</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> OPEN = createField("open", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.high</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> HIGH = createField("high", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.low</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> LOW = createField("low", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.close</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> CLOSE = createField("close", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.volume</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> VOLUME = createField("volume", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.amount</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> AMOUNT = createField("amount", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.ccl</code>.
     */
    public final TableField<StockInfoBackRecord, String> CCL = createField("ccl", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>tushare.stock_info_back.preClose</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> PRECLOSE = createField("preClose", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.netChangeRatio</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> NETCHANGERATIO = createField("netChangeRatio", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.ma5_volume</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> MA5_VOLUME = createField("ma5_volume", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.ma5_avgPrice</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> MA5_AVGPRICE = createField("ma5_avgPrice", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.ma5_ccl</code>.
     */
    public final TableField<StockInfoBackRecord, String> MA5_CCL = createField("ma5_ccl", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>tushare.stock_info_back.ma10_volume</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> MA10_VOLUME = createField("ma10_volume", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.ma10_avgPrice</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> MA10_AVGPRICE = createField("ma10_avgPrice", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.ma10_ccl</code>.
     */
    public final TableField<StockInfoBackRecord, String> MA10_CCL = createField("ma10_ccl", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>tushare.stock_info_back.ma20_volume</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> MA20_VOLUME = createField("ma20_volume", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.ma20_avgPrice</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> MA20_AVGPRICE = createField("ma20_avgPrice", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.ma20_ccl</code>.
     */
    public final TableField<StockInfoBackRecord, String> MA20_CCL = createField("ma20_ccl", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>tushare.stock_info_back.macd_diff</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> MACD_DIFF = createField("macd_diff", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.macd_dea</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> MACD_DEA = createField("macd_dea", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.macd</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> MACD = createField("macd", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.kdj_k</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> KDJ_K = createField("kdj_k", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.kdj_d</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> KDJ_D = createField("kdj_d", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.kdj_j</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> KDJ_J = createField("kdj_j", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.rsi1</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> RSI1 = createField("rsi1", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.rsi2</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> RSI2 = createField("rsi2", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * The column <code>tushare.stock_info_back.rsi3</code>.
     */
    public final TableField<StockInfoBackRecord, BigDecimal> RSI3 = createField("rsi3", org.jooq.impl.SQLDataType.DECIMAL(30, 12), this, "");

    /**
     * Create a <code>tushare.stock_info_back</code> table reference
     */
    public StockInfoBack() {
        this(DSL.name("stock_info_back"), null);
    }

    /**
     * Create an aliased <code>tushare.stock_info_back</code> table reference
     */
    public StockInfoBack(String alias) {
        this(DSL.name(alias), STOCK_INFO_BACK);
    }

    /**
     * Create an aliased <code>tushare.stock_info_back</code> table reference
     */
    public StockInfoBack(Name alias) {
        this(alias, STOCK_INFO_BACK);
    }

    private StockInfoBack(Name alias, Table<StockInfoBackRecord> aliased) {
        this(alias, aliased, null);
    }

    private StockInfoBack(Name alias, Table<StockInfoBackRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Tushare.TUSHARE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.STOCK_INFO_BACK_PRIMARY, Indexes.STOCK_INFO_BACK_STOCK_INFO_BACK_CODE_DATE_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<StockInfoBackRecord, Integer> getIdentity() {
        return Keys.IDENTITY_STOCK_INFO_BACK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<StockInfoBackRecord> getPrimaryKey() {
        return Keys.KEY_STOCK_INFO_BACK_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StockInfoBackRecord>> getKeys() {
        return Arrays.<UniqueKey<StockInfoBackRecord>>asList(Keys.KEY_STOCK_INFO_BACK_PRIMARY, Keys.KEY_STOCK_INFO_BACK_STOCK_INFO_BACK_CODE_DATE_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StockInfoBack as(String alias) {
        return new StockInfoBack(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StockInfoBack as(Name alias) {
        return new StockInfoBack(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public StockInfoBack rename(String name) {
        return new StockInfoBack(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public StockInfoBack rename(Name name) {
        return new StockInfoBack(name, null);
    }
}
