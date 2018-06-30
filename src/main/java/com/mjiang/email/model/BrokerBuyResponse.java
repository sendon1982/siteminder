package com.mjiang.email.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrokerBuyResponse {

    @JsonProperty("Status")
    private String status;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Data")
    private List<BrokerBuyResponseData> stockResponseDataList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BrokerBuyResponseData> getStockResponseDataList() {
        return stockResponseDataList;
    }

    public void setStockResponseDataList(List<BrokerBuyResponseData> stockResponseDataList) {
        this.stockResponseDataList = stockResponseDataList;
    }
}
