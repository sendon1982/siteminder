
package com.mjiang.email.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "k",
    "d",
    "j"
})
public class Kdj {

    @JsonProperty("k")
    private BigDecimal k;

    @JsonProperty("d")
    private BigDecimal d;

    @JsonProperty("j")
    private BigDecimal j;

    @JsonProperty("k")
    public BigDecimal getK() {
        return k;
    }

    @JsonProperty("k")
    public void setK(BigDecimal k) {
        this.k = k;
    }

    @JsonProperty("d")
    public BigDecimal getD() {
        return d;
    }

    @JsonProperty("d")
    public void setD(BigDecimal d) {
        this.d = d;
    }

    @JsonProperty("j")
    public BigDecimal getJ() {
        return j;
    }

    @JsonProperty("j")
    public void setJ(BigDecimal j) {
        this.j = j;
    }

}
