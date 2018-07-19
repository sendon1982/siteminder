package com.mjiang.email.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockTradeHistory {

    @JsonProperty("code")
    public Integer code;

    @JsonProperty("msg")
    public String msg;


}
