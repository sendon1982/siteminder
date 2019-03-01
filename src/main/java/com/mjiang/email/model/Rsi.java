
package com.mjiang.email.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rsi1",
    "rsi2",
    "rsi3"
})
public class Rsi {

    @JsonProperty("rsi1")
    private BigDecimal rsi1;

    @JsonProperty("rsi2")
    private BigDecimal rsi2;

    @JsonProperty("rsi3")
    private BigDecimal rsi3;

    @JsonProperty("rsi1")
    public BigDecimal getRsi1() {
        return rsi1;
    }

    @JsonProperty("rsi1")
    public void setRsi1(BigDecimal rsi1) {
        this.rsi1 = rsi1;
    }

    @JsonProperty("rsi2")
    public BigDecimal getRsi2() {
        return rsi2;
    }

    @JsonProperty("rsi2")
    public void setRsi2(BigDecimal rsi2) {
        this.rsi2 = rsi2;
    }

    @JsonProperty("rsi3")
    public BigDecimal getRsi3() {
        return rsi3;
    }

    @JsonProperty("rsi3")
    public void setRsi3(BigDecimal rsi3) {
        this.rsi3 = rsi3;
    }

}
