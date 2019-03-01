package com.mjiang.email.web.rest;

import com.mjiang.email.model.StockDetailInfo;
import com.mjiang.email.service.StockDetailService;
import com.mjiang.email.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
    path = "/stock/detail/",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
)
public class StockDetailInfoRestController {

    public static final Logger logger = LoggerFactory.getLogger(StockDetailInfoRestController.class);

    @Autowired
    private StockDetailService stockDetailService;

    @PostMapping(value = "no")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Void> postStockDetailInfoNo(@RequestBody String jsonString) {

        StockDetailInfo stockDetailInfo = JsonUtil.convertToObject(jsonString, StockDetailInfo.class);

        int count = stockDetailService.insertStockDetailInfoNo(stockDetailInfo);
        logger.info("Totally {} records have been imported for StockDetailInfoNo", count);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "front")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Void> postStockDetailInfoFront(@RequestBody String jsonString) {

        StockDetailInfo stockDetailInfo = JsonUtil.convertToObject(jsonString, StockDetailInfo.class);

        int count = stockDetailService.insertStockDetailInfoFront(stockDetailInfo);
        logger.info("Totally {} records have been imported for StockDetailInfoFront", count);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "back")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Void> postStockDetailInfoBack(@RequestBody String jsonString) {

        StockDetailInfo stockDetailInfo = JsonUtil.convertToObject(jsonString, StockDetailInfo.class);

        int count = stockDetailService.insertStockDetailInfoBack(stockDetailInfo);
        logger.info("Totally {} records have been imported for StockDetailInfoBack", count);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
