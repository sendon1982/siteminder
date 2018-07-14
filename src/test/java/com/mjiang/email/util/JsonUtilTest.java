package com.mjiang.email.util;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mjiang.email.model.BrokerBuyResponse;
import com.mjiang.email.model.BrokerBuyResponseData;
import com.mjiang.email.model.BrokerPlacedOrder;
import com.mjiang.email.model.StockTradeHistory;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

class JsonUtilTest {

    @Test
    void convertToObject() throws Exception {
        String jsonString = FileUtil.readFileByClasspath("yybcx.json");
        BrokerBuyResponse brokerBuyResponse = JsonUtil.convertToObject(
            jsonString, BrokerBuyResponse.class);

        List<BrokerBuyResponseData> stockResponseDataList = brokerBuyResponse.getStockResponseDataList();
        List<BrokerPlacedOrder> brokerPlacedOrderList = stockResponseDataList.get(0).getBrokerPlacedOrderList();

        assertThat(brokerPlacedOrderList, notNullValue());
    }

    @Test
    void test_convertToObject_TypeReference() {
        String json = "[{\"CodeName\":\"浩丰科技\",\"SCode\":\"300419.SZ\"}," +
            "{\"CodeName\":\"中化岩土\",\"SCode\":\"002542.SZ\"}]";

        List<BrokerPlacedOrder.StockSummary> stockSummaries = JsonUtil.convertToObject(
            json, new TypeReference<List<BrokerPlacedOrder.StockSummary>>() {});

        assertThat(stockSummaries.size(), equalTo(2));
    }

    @Test
    void test_convertToObject_StockTradeHistory() throws Exception {
        String jsonString = FileUtil.readFileByClasspath("stock_trade_history.json");
        List<List<StockTradeHistory>> resultList = JsonUtil.convertToObject(
            jsonString, new TypeReference<List<List<StockTradeHistory>>>() {});
        assertThat(resultList.size(), equalTo(2));

        List<StockTradeHistory> stockTradeHistories = resultList.get(0);
        assertThat(stockTradeHistories, notNullValue());

        StockTradeHistory stockTradeHistory = stockTradeHistories.get(0);
        assertThat(stockTradeHistory, notNullValue());
        assertThat(stockTradeHistory.getCode(), equalTo("002927"));
    }
}