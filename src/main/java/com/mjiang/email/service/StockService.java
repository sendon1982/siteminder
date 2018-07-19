package com.mjiang.email.service;

import java.util.List;

import com.mjiang.email.dao.repository.StockRepository;
import com.mjiang.email.model.StockTradeData;
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
    public int insertStockTradeHistory(List<StockTradeData> stockTradeDataList) {
        int count = 0;

        for (StockTradeData stockTradeData : stockTradeDataList) {
            count = count + this.insertStockTradeHistory(stockTradeData);
        }

        return count;
    }

    @Transactional
    public int insertStockTradeHistory(StockTradeData stockTradeData) {
        int count = 0;

        try {
            stockRepository.insertStockTradeHistory(stockTradeData);
            count++;
        } catch (DuplicateKeyException e) {
            log.warn(e.getMessage());
        }

        return count;
    }
}
