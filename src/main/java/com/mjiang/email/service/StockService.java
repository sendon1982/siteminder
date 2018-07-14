package com.mjiang.email.service;

import java.util.List;

import com.mjiang.email.dao.repository.BrokerRepository;
import com.mjiang.email.dao.repository.StockRepository;
import com.mjiang.email.model.BrokerBuyResponse;
import com.mjiang.email.model.BrokerBuyResponseData;
import com.mjiang.email.model.BrokerPlacedOrder;
import com.mjiang.email.model.BrokerPlacedOrder.StockSummary;
import com.mjiang.email.model.StockTradeHistory;
import com.mjiang.email.util.FileUtil;
import com.mjiang.email.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private static final Logger log = LoggerFactory.getLogger(StockService.class);

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public int insertStockTradeHistory(List<StockTradeHistory> stockTradeHistories) {
        int count = 0;

        for (StockTradeHistory stockTradeHistory : stockTradeHistories) {
            count = count + this.insertStockTradeHistory(stockTradeHistory);
        }

        return count;
    }

    @Transactional
    public int insertStockTradeHistory(StockTradeHistory stockTradeHistory) {
        int count = 0;

        try {
            stockRepository.insertStockTradeHistory(stockTradeHistory);
            count++;
        } catch (DuplicateKeyException e) {
            log.warn(e.getMessage());
        }

        return count;
    }
}
