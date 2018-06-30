package com.mjiang.email.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalDate;

public class BrokerPlacedOrder {

    /**
     * "SName,YybCode,YybName,Smoney,Bmoney,JmMoney,YybBCount,YybSCount,TDate"
     */
    private List<StockSummary> stockSummaryList = new ArrayList<>();

    private String brokerCode;

    private String brokerName;

    private BigDecimal sMoney;

    private BigDecimal bMoney;

    private BigDecimal jmMoney;

    private long brokerBuyCount;

    private long brokerSellCount;

    private LocalDate date;

    public List<StockSummary> getStockSummaryList() {
        return stockSummaryList;
    }

    public void setStockSummaryList(List<StockSummary> stockSummaryList) {
        this.stockSummaryList = stockSummaryList;
    }

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public BigDecimal getsMoney() {
        return sMoney;
    }

    public void setsMoney(BigDecimal sMoney) {
        this.sMoney = sMoney;
    }

    public BigDecimal getbMoney() {
        return bMoney;
    }

    public void setbMoney(BigDecimal bMoney) {
        this.bMoney = bMoney;
    }

    public BigDecimal getJmMoney() {
        return jmMoney;
    }

    public void setJmMoney(BigDecimal jmMoney) {
        this.jmMoney = jmMoney;
    }

    public long getBrokerBuyCount() {
        return brokerBuyCount;
    }

    public void setBrokerBuyCount(long brokerBuyCount) {
        this.brokerBuyCount = brokerBuyCount;
    }

    public long getBrokerSellCount() {
        return brokerSellCount;
    }

    public void setBrokerSellCount(long brokerSellCount) {
        this.brokerSellCount = brokerSellCount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static class StockSummary {

        @JsonProperty("SCode")
        private String code;

        @JsonProperty("CodeName")
        private String codeName;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCodeName() {
            return codeName;
        }

        public void setCodeName(String codeName) {
            this.codeName = codeName;
        }
    }
}
