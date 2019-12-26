package com.mjiang.email.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockSmartWatchData {

    @JsonProperty("tc")
    private Integer tc;

    @JsonProperty("allstock")
    private List<SmartWatchAllStock> allstock;

    public Integer getTc() {
        return tc;
    }

    public void setTc(Integer tc) {
        this.tc = tc;
    }

    public List<SmartWatchAllStock> getAllstock() {
        return allstock;
    }

    public void setAllstock(List<SmartWatchAllStock> allstock) {
        this.allstock = allstock;
    }
}
