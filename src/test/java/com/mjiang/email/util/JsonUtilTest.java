package com.mjiang.email.util;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mjiang.email.model.BrokerBuyResponse;
import com.mjiang.email.model.BrokerBuyResponseData;
import com.mjiang.email.model.BrokerPlacedOrder;
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
}