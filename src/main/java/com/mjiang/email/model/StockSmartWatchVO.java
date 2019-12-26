package com.mjiang.email.model;

import java.math.BigDecimal;

import org.joda.time.LocalDateTime;

public class StockSmartWatchVO {

    private Long id;

    private String stockCode;

    private String stockName;

    private String mType;

    private LocalDateTime dateTime;

    private String typeCode;

    private BigDecimal information;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public BigDecimal getInformation() {
        return information;
    }

    public void setInformation(BigDecimal information) {
        this.information = information;
    }
}
