package com.mjiang.email.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mjiang.email.model.BrokerBuyResponse;
import com.mjiang.email.model.BrokerBuyResponseData;
import com.mjiang.email.model.BrokerPlacedOrder;
import com.mjiang.email.model.StockTradeData;
import com.mjiang.email.model.StockTradeHistory;
import org.joda.time.LocalDate;
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

        Map<String, Object> resultMap = JsonUtil.convertToMap(jsonString);
        assertThat(resultMap, notNullValue());

        List<StockTradeData> stockTradeDataList = StockTradeHistoryUtil.convertToStockTradeData(resultMap);
        assertThat(stockTradeDataList.size(), equalTo(2));

        assertThat(stockTradeDataList, allOf(
            containsInAnyOrder(
                allOf(
                    hasProperty("code", equalTo("sh600000")),
                    hasProperty("date", equalTo(LocalDate.parse("2017-01-03"))),
                    hasProperty("openPrice", equalTo(BigDecimal.valueOf(12.184))),
                    hasProperty("closePrice", equalTo(BigDecimal.valueOf(12.251))),
                    hasProperty("highPrice", equalTo(BigDecimal.valueOf(12.356))),
                    hasProperty("lowPrice", equalTo(BigDecimal.valueOf(12.153))),
                    hasProperty("volume", equalTo(BigDecimal.valueOf(162371.000)))
                ),
                allOf(
                    hasProperty("code", equalTo("sh600000")),
                    hasProperty("date", equalTo(LocalDate.parse("2017-01-04"))),
                    hasProperty("openPrice", equalTo(BigDecimal.valueOf(12.244))),
                    hasProperty("closePrice", equalTo(BigDecimal.valueOf(12.274))),
                    hasProperty("highPrice", equalTo(BigDecimal.valueOf(12.289))),
                    hasProperty("lowPrice", equalTo(BigDecimal.valueOf(12.161))),
                    hasProperty("volume", equalTo(BigDecimal.valueOf(296587.000)))
                )
            ))
        );
    }
}