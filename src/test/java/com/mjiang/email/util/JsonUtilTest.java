package com.mjiang.email.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mjiang.email.model.BrokerBuyResponse;
import com.mjiang.email.model.BrokerBuyResponseData;
import com.mjiang.email.model.BrokerPlacedOrder;
import com.mjiang.email.model.MashDatum;
import com.mjiang.email.model.StockDetailInfo;
import com.mjiang.email.model.StockTradeData;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.notNullValue;

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

    @Test
    void test_convertToObject_NewStockInfo() throws Exception {
        String jsonString = FileUtil.readFileByClasspath("new_stock_info.json");

        StockDetailInfo stockDetailInfo = JsonUtil.convertToObject(jsonString, StockDetailInfo.class);
        assertThat(stockDetailInfo, notNullValue());

        assertThat(stockDetailInfo.getErrorNo(), equalTo(0));
        assertThat(stockDetailInfo.getErrorMsg(), equalTo("SUCCESS"));
        assertThat(stockDetailInfo.getStockCode(), equalTo("600000"));
        assertThat(stockDetailInfo.getMashData().size(), equalTo(2));

        MashDatum mashDatum = stockDetailInfo.getMashData().get(0);
        assertThat(mashDatum.getDate(), equalTo(LocalDate.parse("2017-01-04")));
        assertThat(mashDatum.getKline().getOpen().doubleValue(), equalTo(12.060000419617));
        assertThat(mashDatum.getKline().getHigh().doubleValue(), equalTo(12.199999809265));
        assertThat(mashDatum.getKline().getCcl(), equalTo("0"));
    }

    @Test
    void test_convertToObject_ErrorJson() throws Exception {
        String jsonString = FileUtil.readFileByClasspath("errorResponse.json");

        StockDetailInfo stockDetailInfo = JsonUtil.convertToObject(jsonString, StockDetailInfo.class);
        assertThat(stockDetailInfo, notNullValue());
    }
}