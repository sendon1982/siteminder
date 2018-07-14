package com.mjiang.email.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalDate;

public class StockTradeHistory {

    @JsonProperty("code")
    private String code;

    @JsonProperty("startdate")
    private LocalDate startdate;

    @JsonProperty("stock_table_id")
    private Integer stockTableId;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("open")
    private BigDecimal open;

    @JsonProperty("close")
    private BigDecimal close;

    @JsonProperty("high")
    private BigDecimal high;

    @JsonProperty("low")
    private BigDecimal low;

    @JsonProperty("volume")
    private BigDecimal volume;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public Integer getStockTableId() {
        return stockTableId;
    }

    public void setStockTableId(Integer stockTableId) {
        this.stockTableId = stockTableId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }
}