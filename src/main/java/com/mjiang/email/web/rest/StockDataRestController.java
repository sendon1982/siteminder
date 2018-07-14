package com.mjiang.email.web.rest;

import java.util.List;

import com.mjiang.email.model.StockTradeHistory;
import com.mjiang.email.model.StockTradeHistoryRequest;
import com.mjiang.email.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock/")
public class StockDataRestController {

    public static final Logger logger = LoggerFactory.getLogger(StockDataRestController.class);

    @Autowired
    private StockService stockService;

    @PostMapping(value = "tradeHistory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> postPurchaseSummary(@RequestBody List<List<StockTradeHistory>> stockTradeHistoryList) {

        for (List<StockTradeHistory> stockTradeHistories : stockTradeHistoryList) {
            int count = stockService.insertStockTradeHistory(stockTradeHistories);
            logger.info("Totally {} records have been imported", count);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
