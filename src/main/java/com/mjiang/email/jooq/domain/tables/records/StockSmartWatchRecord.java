/*
 * This file is generated by jOOQ.
*/
package com.mjiang.email.jooq.domain.tables.records;


import com.mjiang.email.jooq.domain.tables.StockSmartWatch;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


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
public class StockSmartWatchRecord extends UpdatableRecordImpl<StockSmartWatchRecord> implements Record7<Long, String, String, String, Timestamp, String, BigDecimal> {

    private static final long serialVersionUID = 371285815;

    /**
     * Setter for <code>tushare.stock_smart_watch.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>tushare.stock_smart_watch.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tushare.stock_smart_watch.stock_code</code>.
     */
    public void setStockCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>tushare.stock_smart_watch.stock_code</code>.
     */
    public String getStockCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>tushare.stock_smart_watch.stock_name</code>.
     */
    public void setStockName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>tushare.stock_smart_watch.stock_name</code>.
     */
    public String getStockName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tushare.stock_smart_watch.m_type</code>.
     */
    public void setMType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>tushare.stock_smart_watch.m_type</code>.
     */
    public String getMType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>tushare.stock_smart_watch.date_time</code>.
     */
    public void setDateTime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>tushare.stock_smart_watch.date_time</code>.
     */
    public Timestamp getDateTime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>tushare.stock_smart_watch.type_code</code>.
     */
    public void setTypeCode(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>tushare.stock_smart_watch.type_code</code>.
     */
    public String getTypeCode() {
        return (String) get(5);
    }

    /**
     * Setter for <code>tushare.stock_smart_watch.information</code>.
     */
    public void setInformation(BigDecimal value) {
        set(6, value);
    }

    /**
     * Getter for <code>tushare.stock_smart_watch.information</code>.
     */
    public BigDecimal getInformation() {
        return (BigDecimal) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, String, String, String, Timestamp, String, BigDecimal> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, String, String, String, Timestamp, String, BigDecimal> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return StockSmartWatch.STOCK_SMART_WATCH.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return StockSmartWatch.STOCK_SMART_WATCH.STOCK_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return StockSmartWatch.STOCK_SMART_WATCH.STOCK_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return StockSmartWatch.STOCK_SMART_WATCH.M_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return StockSmartWatch.STOCK_SMART_WATCH.DATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return StockSmartWatch.STOCK_SMART_WATCH.TYPE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field7() {
        return StockSmartWatch.STOCK_SMART_WATCH.INFORMATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getStockCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getStockName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getMType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getDateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getTypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component7() {
        return getInformation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getStockCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getStockName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getMType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getDateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getTypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value7() {
        return getInformation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StockSmartWatchRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StockSmartWatchRecord value2(String value) {
        setStockCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StockSmartWatchRecord value3(String value) {
        setStockName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StockSmartWatchRecord value4(String value) {
        setMType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StockSmartWatchRecord value5(Timestamp value) {
        setDateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StockSmartWatchRecord value6(String value) {
        setTypeCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StockSmartWatchRecord value7(BigDecimal value) {
        setInformation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StockSmartWatchRecord values(Long value1, String value2, String value3, String value4, Timestamp value5, String value6, BigDecimal value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StockSmartWatchRecord
     */
    public StockSmartWatchRecord() {
        super(StockSmartWatch.STOCK_SMART_WATCH);
    }

    /**
     * Create a detached, initialised StockSmartWatchRecord
     */
    public StockSmartWatchRecord(Long id, String stockCode, String stockName, String mType, Timestamp dateTime, String typeCode, BigDecimal information) {
        super(StockSmartWatch.STOCK_SMART_WATCH);

        set(0, id);
        set(1, stockCode);
        set(2, stockName);
        set(3, mType);
        set(4, dateTime);
        set(5, typeCode);
        set(6, information);
    }
}
