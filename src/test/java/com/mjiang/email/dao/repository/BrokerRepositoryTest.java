package com.mjiang.email.dao.repository;

import java.math.BigDecimal;

import com.mjiang.email.model.BrokerPlacedOrder;
import org.joda.time.LocalDate;
import org.junit.Ignore;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@Tag("ManualTest")
@Ignore
class BrokerRepositoryTest extends BaseRepositoryTest {

    @Autowired
    BrokerRepository brokerRepository;

    @Test
    void test_insertBrokerPlacedOrder() {
        BrokerPlacedOrder brokerPlacedOrder = new BrokerPlacedOrder();

        brokerPlacedOrder.setBrokerCode("80100185");
        brokerPlacedOrder.setBrokerName("东方证券股份有限公司杭州龙井路证券营业部");
        brokerPlacedOrder.setsMoney(new BigDecimal(66490));
        brokerPlacedOrder.setbMoney(new BigDecimal(727777331.31));
        brokerPlacedOrder.setJmMoney(new BigDecimal(727710841.31));
        brokerPlacedOrder.setBrokerBuyCount(1);
        brokerPlacedOrder.setBrokerSellCount(0);
        brokerPlacedOrder.setDate(LocalDate.parse("2017-03-16"));

        long result = brokerRepository.insertBrokerBuySummary(brokerPlacedOrder);
        assertThat(result, notNullValue());
    }
}