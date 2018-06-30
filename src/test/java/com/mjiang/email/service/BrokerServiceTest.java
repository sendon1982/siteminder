package com.mjiang.email.service;

import java.util.List;

import com.mjiang.email.config.JpaConfig;
import com.mjiang.email.model.BrokerPlacedOrder;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaConfig.class })
@TestPropertySource(value = {"classpath:application.test.properties"})
@Tag("ManualTest")
class BrokerServiceTest {

    @Autowired
    private BrokerService brokerService;

    @Test
    void insertBrokerPlacedOrders() throws Exception {
        List<BrokerPlacedOrder> brokerPlacedOrders = brokerService.getBrokerPlacedOrdersFromClassPathFile("yybcx.json");
        brokerService.insertBrokerPlacedOrders(brokerPlacedOrders);
    }

    @Test
    void getBrokerPlacedOrdersFromClassPathFile() throws Exception {
        List<BrokerPlacedOrder> brokerPlacedOrders = brokerService.getBrokerPlacedOrdersFromClassPathFile("yybcx.json");
        assertThat(brokerPlacedOrders, notNullValue());
    }
}