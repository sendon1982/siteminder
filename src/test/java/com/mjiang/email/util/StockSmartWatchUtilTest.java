package com.mjiang.email.util;

import java.util.List;
import java.util.Map;

import com.mjiang.email.model.StockSmartWatchVO;
import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.json.Json;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

class StockSmartWatchUtilTest {

    @Test
    void test_convertToStockSmartWatchVOList() throws Exception {
        String jsonString = FileUtil.readFileByClasspath("stock_smart_watch.json");
        List<StockSmartWatchVO> resultList = StockSmartWatchUtil.convertToStockSmartWatchVOList(jsonString);

        assertThat(resultList, hasSize(2));

        StockSmartWatchVO smartWatchVO = resultList.get(0);

        assertThat(smartWatchVO.getStockCode(), equalTo("603982"));
        assertThat(smartWatchVO.getStockName(), equalTo("泉峰汽车"));
        assertThat(smartWatchVO.getDateTime(), equalTo(LocalDateTime.parse("2019-12-26T14:40:48.000")));
        assertThat(smartWatchVO.getmType(), equalTo("1"));
        assertThat(smartWatchVO.getTypeCode(), equalTo("8202"));
        assertThat(smartWatchVO.getInformation().toString(), equalTo("0.026685"));
    }
}