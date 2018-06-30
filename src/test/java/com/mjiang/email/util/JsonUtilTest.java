package com.mjiang.email.util;

import java.util.HashMap;
import java.util.List;

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
}