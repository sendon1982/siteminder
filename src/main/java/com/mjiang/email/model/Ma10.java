
package com.mjiang.email.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "volume",
    "avgPrice",
    "ccl"
})
public class Ma10 {

    @JsonProperty("volume")
    private Integer volume;

    @JsonProperty("avgPrice")
    private BigDecimal avgPrice;

    @JsonProperty("ccl")
    private String ccl;

    @JsonProperty("volume")
    public Integer getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @JsonProperty("avgPrice")
    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    @JsonProperty("avgPrice")
    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }

    @JsonProperty("ccl")
    public String getCcl() {
        return ccl;
    }

    @JsonProperty("ccl")
    public void setCcl(String ccl) {
        this.ccl = ccl;
    }

}
