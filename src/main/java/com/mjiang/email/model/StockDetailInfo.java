
package com.mjiang.email.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "errorNo",
    "errorMsg",
    "mashData",
    "stock_code"
})
public class StockDetailInfo {

    @JsonProperty("errorNo")
    private Integer errorNo;

    @JsonProperty("errorMsg")
    private String errorMsg;

    @JsonProperty("mashData")
    private List<MashDatum> mashData = new ArrayList<>();

    @JsonProperty("stock_code")
    private String stockCode;

    @JsonProperty("errorNo")
    public Integer getErrorNo() {
        return errorNo;
    }

    @JsonProperty("errorNo")
    public void setErrorNo(Integer errorNo) {
        this.errorNo = errorNo;
    }

    @JsonProperty("errorMsg")
    public String getErrorMsg() {
        return errorMsg;
    }

    @JsonProperty("errorMsg")
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @JsonProperty("mashData")
    public List<MashDatum> getMashData() {
        return mashData;
    }

    @JsonProperty("mashData")
    public void setMashData(List<MashDatum> mashData) {
        this.mashData = mashData;
    }

    @JsonProperty("stock_code")
    public String getStockCode() {
        return stockCode;
    }

    @JsonProperty("stock_code")
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

}
