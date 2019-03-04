
package com.mjiang.email.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "open",
    "high",
    "low",
    "close",
    "volume",
    "amount",
    "ccl",
    "preClose",
    "netChangeRatio"
})
public class Kline {

    @JsonProperty("open")
    private BigDecimal open;

    @JsonProperty("high")
    private BigDecimal high;

    @JsonProperty("low")
    private BigDecimal low;

    @JsonProperty("close")
    private BigDecimal close;

    @JsonProperty("volume")
    private Long volume;

    @JsonProperty("amount")
    private Long amount;

    @JsonProperty("ccl")
    @JsonIgnore
    private String ccl;

    @JsonProperty("preClose")
    private BigDecimal preClose;

    @JsonProperty("netChangeRatio")
    private BigDecimal netChangeRatio;

    @JsonProperty("open")
    public BigDecimal getOpen() {
        return open;
    }

    @JsonProperty("open")
    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    @JsonProperty("high")
    public BigDecimal getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    @JsonProperty("low")
    public BigDecimal getLow() {
        return low;
    }

    @JsonProperty("low")
    public void setLow(BigDecimal low) {
        this.low = low;
    }

    @JsonProperty("close")
    public BigDecimal getClose() {
        return close;
    }

    @JsonProperty("close")
    public void setClose(BigDecimal close) {
        this.close = close;
    }

    @JsonProperty("volume")
    public Long getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @JsonProperty("amount")
    public Long getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @JsonProperty("ccl")
    public String getCcl() {
        return ccl;
    }

    @JsonProperty("ccl")
    public void setCcl(String ccl) {
        this.ccl = ccl;
    }

    @JsonProperty("preClose")
    public BigDecimal getPreClose() {
        return preClose;
    }

    @JsonProperty("preClose")
    public void setPreClose(BigDecimal preClose) {
        this.preClose = preClose;
    }

    @JsonProperty("netChangeRatio")
    public BigDecimal getNetChangeRatio() {
        return netChangeRatio;
    }

    @JsonProperty("netChangeRatio")
    public void setNetChangeRatio(BigDecimal netChangeRatio) {
        this.netChangeRatio = netChangeRatio;
    }

}
