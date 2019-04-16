package com.mjiang.email.util;

import java.util.List;

import org.junit.jupiter.api.Test;
import quant.fans.Quants;
import quant.fans.model.StockData;

class KdjlTest {

    @Test
    void convertToObject() throws Exception {
        Quants quants = new Quants();
        //获取股票列表
        List<String> list = quants.data.stockList();

        for (String stock : list) {
            //StockData代表一个时间片的数据，例如日线级别，每个StockData为一天收盘后的股票数据
            List<StockData> stockDatas = quants.data.dailyData(stock);
            //剔除交易数据小于60天的股票
            if (stockDatas == null || stockDatas.size() < 60) {
                continue;
            }
            //indicator包含常用指标的计算
            quants.indicator.macd(stockDatas);
            //获取5、10、20、30、40、60均线，也可以通过sma(stockDatas,ma)获取指定时间间隔的均线
            quants.indicator.sma(stockDatas);
            quants.indicator.boll(stockDatas);
            quants.indicator.kdj(stockDatas);
            //strategy包含简单的策略计算，例如macd金叉
            quants.strategy.macdCross(stockDatas);
            quants.strategy.kdjCross(stockDatas);
            quants.strategy.goldenSpider(stockDatas);

            quants.strategy.bollThroat(stockDatas);
            for (StockData stockData : stockDatas) {
                System.out.println(stockData);
            }
        }
    }

    @Test
    void test_stockBuySell() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

        int[] prices2 = {2, 4, 1};
        System.out.println(maxProfit(prices2));

        int[] prices3 = {2, 1, 2, 1, 0, 1, 2};
        System.out.println(maxProfit(prices3));

        int[] prices4 = {7,6,4,3,1};
        System.out.println(maxProfit(prices4));

    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }

            int extra = prices[i] - min;

            if (extra > profit) {
                profit = extra;
            }
        }

        return profit;
    }
}