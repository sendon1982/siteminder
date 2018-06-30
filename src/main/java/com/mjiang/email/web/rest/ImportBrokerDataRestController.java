package com.mjiang.email.web.rest;

import java.util.List;

import com.mjiang.email.model.BrokerPlacedOrder;
import com.mjiang.email.service.BrokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/broker/")
public class ImportBrokerDataRestController {

    public static final Logger logger = LoggerFactory.getLogger(ImportBrokerDataRestController.class);

    @Autowired
    private BrokerService brokerService;

    @GetMapping(value = "import", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> importData() throws Exception {
        String fileName = "yybcx.json";

        List<BrokerPlacedOrder> brokerPlacedOrders = brokerService.getBrokerPlacedOrdersFromClassPathFile(fileName);
        int size = brokerPlacedOrders.size();

        logger.info("load {} records from json file {}", size, fileName);

        brokerService.insertBrokerPlacedOrders(brokerPlacedOrders);
        logger.info("Totally {} records have been imported", size);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
