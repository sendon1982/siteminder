package com.mjiang.email.web.rest;

import java.util.List;

import com.mjiang.email.model.BrokerBuyRequest;
import com.mjiang.email.model.BrokerBuyResponseData;
import com.mjiang.email.model.BrokerPlacedOrder;
import com.mjiang.email.service.BrokerService;
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
@RequestMapping("/broker/")
public class BrokerDataRestController {

    public static final Logger logger = LoggerFactory.getLogger(BrokerDataRestController.class);

    @Autowired
    private BrokerService brokerService;

    @PostMapping(value = "purchaseSummary", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> postPurchaseSummary(@RequestBody BrokerBuyRequest request) throws Exception {
        BrokerBuyResponseData brokerBuyResponseData = request.getStockResponseDataList().get(0);
        List<BrokerPlacedOrder> brokerPlacedOrderList = brokerBuyResponseData.getBrokerPlacedOrderList();
        brokerService.insertBrokerPlacedOrders(brokerPlacedOrderList);

        logger.info("Totally {} records have been imported", brokerPlacedOrderList.size());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
