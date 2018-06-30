package com.mjiang.email.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mjiang.email.model.BrokerPlacedOrder.StockSummary;
import com.mjiang.email.util.JsonUtil;
import org.joda.time.LocalDate;
import org.springframework.util.StringUtils;

public class BrokerBuyResponseData {

    @JsonProperty("TableName")
    private String tableName;

    @JsonProperty("TotalPage")
    private String totalPage;

    @JsonProperty("ConsumeMSecond")
    private String consumeMSecond;

    @JsonProperty("SplitSymbol")
    private String splitSymbol;

    @JsonProperty("FieldName")
    private String fieldName;

    @JsonProperty("Data")
    private List<String> data;

    private List<BrokerPlacedOrder> brokerPlacedOrders = new ArrayList<>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public String getConsumeMSecond() {
        return consumeMSecond;
    }

    public void setConsumeMSecond(String consumeMSecond) {
        this.consumeMSecond = consumeMSecond;
    }

    public String getSplitSymbol() {
        return splitSymbol;
    }

    public void setSplitSymbol(String splitSymbol) {
        this.splitSymbol = splitSymbol;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<BrokerPlacedOrder> getBrokerPlacedOrderList() {
        String separator = "\\" + getSplitSymbol();

        for (String record : data) {
            String[] recordArray = record.split(separator);
            BrokerPlacedOrder brokerPlacedOrder = buildBrokerPlacedOrder(recordArray);
            brokerPlacedOrders.add(brokerPlacedOrder);
        }

        return brokerPlacedOrders;
    }

    private BrokerPlacedOrder buildBrokerPlacedOrder(String[] recordArray) {
        BrokerPlacedOrder brokerPlacedOrder = new BrokerPlacedOrder();

        List<StockSummary> stockSummaryList = JsonUtil.convertToObject(
            recordArray[0], new TypeReference<List<StockSummary>>(){});

        brokerPlacedOrder.setStockSummaryList(stockSummaryList);

        brokerPlacedOrder.setBrokerCode(recordArray[1]);
        brokerPlacedOrder.setBrokerName(recordArray[2]);
        brokerPlacedOrder.setsMoney(convertToBigDecimal(recordArray[3]));
        brokerPlacedOrder.setbMoney(convertToBigDecimal(recordArray[4]));
        brokerPlacedOrder.setJmMoney(convertToBigDecimal(recordArray[5]));
        brokerPlacedOrder.setBrokerBuyCount(convertToLong(recordArray[6]));
        brokerPlacedOrder.setBrokerSellCount(convertToLong(recordArray[7]));
        brokerPlacedOrder.setDate(LocalDate.parse(recordArray[8]));

        return brokerPlacedOrder;
    }

    private BigDecimal convertToBigDecimal(String source) {
        BigDecimal result = null;

        if (StringUtils.isEmpty(source)) {
            return result;
        }

        try {
            result = new BigDecimal(source.trim());
        } catch (NumberFormatException e) {
            result = null;
        }

        return result;
    }

    private long convertToLong(String source) {
        long result = 0;

        if (StringUtils.isEmpty(source)) {
            return result;
        }

        try {
            result = Long.parseLong(source.trim());
        } catch (NumberFormatException e) {
            result = 0;
        }

        return result;
    }
}
