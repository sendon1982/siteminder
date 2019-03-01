package com.mjiang.email.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mjiang.email.jackson.LocalDateDeserializer;
import org.joda.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"date", "kline", "ma5", "ma10", "ma20", "macd", "kdj", "rsi"})
public class MashDatum {

    @JsonProperty("date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @JsonProperty("kline")
    private Kline kline;

    @JsonProperty("ma5")
    private Ma5 ma5;

    @JsonProperty("ma10")
    private Ma10 ma10;

    @JsonProperty("ma20")
    private Ma20 ma20;

    @JsonProperty("macd")
    private Macd macd;

    @JsonProperty("kdj")
    private Kdj kdj;

    @JsonProperty("rsi")
    private Rsi rsi;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Kline getKline() {
        return kline;
    }

    public void setKline(Kline kline) {
        this.kline = kline;
    }

    public Ma5 getMa5() {
        return ma5;
    }

    public void setMa5(Ma5 ma5) {
        this.ma5 = ma5;
    }

    public Ma10 getMa10() {
        return ma10;
    }

    public void setMa10(Ma10 ma10) {
        this.ma10 = ma10;
    }

    public Ma20 getMa20() {
        return ma20;
    }

    public void setMa20(Ma20 ma20) {
        this.ma20 = ma20;
    }

    public Macd getMacd() {
        return macd;
    }

    public void setMacd(Macd macd) {
        this.macd = macd;
    }

    public Kdj getKdj() {
        return kdj;
    }

    public void setKdj(Kdj kdj) {
        this.kdj = kdj;
    }

    public Rsi getRsi() {
        return rsi;
    }

    public void setRsi(Rsi rsi) {
        this.rsi = rsi;
    }
}
