package com.mjiang.email.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockSmartWatchResponse {

    @JsonProperty("rc")
    private Integer rc;

    @JsonProperty("rt")
    private Integer rt;

    @JsonProperty("svr")
    private Integer svr;

    @JsonProperty("lt")
    private Integer lt;

    @JsonProperty("full")
    private Integer full;

    @JsonProperty("data")
    private StockSmartWatchData data;

    public Integer getRc() {
        return rc;
    }

    public void setRc(Integer rc) {
        this.rc = rc;
    }

    public Integer getRt() {
        return rt;
    }

    public void setRt(Integer rt) {
        this.rt = rt;
    }

    public Integer getSvr() {
        return svr;
    }

    public void setSvr(Integer svr) {
        this.svr = svr;
    }

    public Integer getLt() {
        return lt;
    }

    public void setLt(Integer lt) {
        this.lt = lt;
    }

    public Integer getFull() {
        return full;
    }

    public void setFull(Integer full) {
        this.full = full;
    }

    public StockSmartWatchData getData() {
        return data;
    }

    public void setData(StockSmartWatchData data) {
        this.data = data;
    }
}