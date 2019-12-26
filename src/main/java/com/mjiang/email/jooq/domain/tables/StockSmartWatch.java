/*
 * This file is generated by jOOQ.
*/
package com.mjiang.email.jooq.domain.tables;


import com.mjiang.email.jooq.domain.Indexes;
import com.mjiang.email.jooq.domain.Keys;
import com.mjiang.email.jooq.domain.Tushare;
import com.mjiang.email.jooq.domain.tables.records.StockSmartWatchRecord;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
public class StockSmartWatch extends TableImpl<StockSmartWatchRecord> {

    private static final long serialVersionUID = 1945833789;

    /**
     * The reference instance of <code>tushare.stock_smart_watch</code>
     */
    public static final StockSmartWatch STOCK_SMART_WATCH = new StockSmartWatch();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StockSmartWatchRecord> getRecordType() {
        return StockSmartWatchRecord.class;
    }

    /**
     * The column <code>tushare.stock_smart_watch.id</code>.
     */
    public final TableField<StockSmartWatchRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>tushare.stock_smart_watch.stock_code</code>.
     */
    public final TableField<StockSmartWatchRecord, String> STOCK_CODE = createField("stock_code", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>tushare.stock_smart_watch.stock_name</code>.
     */
    public final TableField<StockSmartWatchRecord, String> STOCK_NAME = createField("stock_name", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>tushare.stock_smart_watch.m_type</code>.
     */
    public final TableField<StockSmartWatchRecord, String> M_TYPE = createField("m_type", org.jooq.impl.SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>tushare.stock_smart_watch.date_time</code>.
     */
    public final TableField<StockSmartWatchRecord, Timestamp> DATE_TIME = createField("date_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>tushare.stock_smart_watch.type_code</code>.
     */
    public final TableField<StockSmartWatchRecord, String> TYPE_CODE = createField("type_code", org.jooq.impl.SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>tushare.stock_smart_watch.information</code>.
     */
    public final TableField<StockSmartWatchRecord, BigDecimal> INFORMATION = createField("information", org.jooq.impl.SQLDataType.DECIMAL(30, 10), this, "");

    /**
     * Create a <code>tushare.stock_smart_watch</code> table reference
     */
    public StockSmartWatch() {
        this(DSL.name("stock_smart_watch"), null);
    }

    /**
     * Create an aliased <code>tushare.stock_smart_watch</code> table reference
     */
    public StockSmartWatch(String alias) {
        this(DSL.name(alias), STOCK_SMART_WATCH);
    }

    /**
     * Create an aliased <code>tushare.stock_smart_watch</code> table reference
     */
    public StockSmartWatch(Name alias) {
        this(alias, STOCK_SMART_WATCH);
    }

    private StockSmartWatch(Name alias, Table<StockSmartWatchRecord> aliased) {
        this(alias, aliased, null);
    }

    private StockSmartWatch(Name alias, Table<StockSmartWatchRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.STOCK_SMART_WATCH_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<StockSmartWatchRecord, Long> getIdentity() {
        return Keys.IDENTITY_STOCK_SMART_WATCH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<StockSmartWatchRecord> getPrimaryKey() {
        return Keys.KEY_STOCK_SMART_WATCH_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StockSmartWatchRecord>> getKeys() {
        return Arrays.<UniqueKey<StockSmartWatchRecord>>asList(Keys.KEY_STOCK_SMART_WATCH_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StockSmartWatch as(String alias) {
        return new StockSmartWatch(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StockSmartWatch as(Name alias) {
        return new StockSmartWatch(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public StockSmartWatch rename(String name) {
        return new StockSmartWatch(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public StockSmartWatch rename(Name name) {
        return new StockSmartWatch(name, null);
    }
}
