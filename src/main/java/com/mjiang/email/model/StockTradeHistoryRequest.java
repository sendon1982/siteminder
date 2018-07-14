package com.mjiang.email.model;

import java.util.List;

public class StockTradeHistoryRequest {

    private List<List<StockTradeHistory>> stockTradeHistoryList;

    public List<List<StockTradeHistory>> getStockTradeHistoryList() {
        return stockTradeHistoryList;
    }

    public void setStockTradeHistoryList(List<List<StockTradeHistory>> stockTradeHistoryList) {
        this.stockTradeHistoryList = stockTradeHistoryList;
    }
}
