
package com.mjiang.email.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "diff",
    "dea",
    "macd"
})
public class Macd {

    @JsonProperty("diff")
    private BigDecimal diff;

    @JsonProperty("dea")
    private BigDecimal dea;

    @JsonProperty("macd")
    private BigDecimal macd;

    @JsonProperty("diff")
    public BigDecimal getDiff() {
        return diff;
    }

    @JsonProperty("diff")
    public void setDiff(BigDecimal diff) {
        this.diff = diff;
    }

    @JsonProperty("dea")
    public BigDecimal getDea() {
        return dea;
    }

    @JsonProperty("dea")
    public void setDea(BigDecimal dea) {
        this.dea = dea;
    }

    @JsonProperty("macd")
    public BigDecimal getMacd() {
        return macd;
    }

    @JsonProperty("macd")
    public void setMacd(BigDecimal macd) {
        this.macd = macd;
    }

}
