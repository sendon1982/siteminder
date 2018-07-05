package com.mjiang.email.service;

import java.util.List;

import com.mjiang.email.dao.repository.BrokerRepository;
import com.mjiang.email.model.BrokerBuyResponse;
import com.mjiang.email.model.BrokerBuyResponseData;
import com.mjiang.email.model.BrokerPlacedOrder;
import com.mjiang.email.model.BrokerPlacedOrder.StockSummary;
import com.mjiang.email.util.FileUtil;
import com.mjiang.email.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrokerService {

    private static final Logger log = LoggerFactory.getLogger(BrokerService.class);

    @Autowired
    private BrokerRepository brokerRepository;

    @Transactional
    public int insertBrokerPlacedOrders(List<BrokerPlacedOrder> brokerPlacedOrders) {
        int count = 0;

        for (BrokerPlacedOrder brokerPlacedOrder : brokerPlacedOrders) {
            count = count + insertBrokerPlacedOrder(brokerPlacedOrder);
        }

        return count;
    }

    @Transactional
    public int insertBrokerPlacedOrder(BrokerPlacedOrder brokerPlacedOrder) {
        long brokerBuySummaryId = 0;
        try {
            brokerBuySummaryId = brokerRepository.insertBrokerBuySummary(brokerPlacedOrder);
        } catch (DuplicateKeyException e) {
            log.warn(e.getMessage());
        }

        if (brokerBuySummaryId == 0) {
            return 0;
        }

        for (StockSummary stockSummary : brokerPlacedOrder.getStockSummaryList()) {
            try {
                brokerRepository.insertBrokerBuyStockInfo(brokerBuySummaryId, stockSummary);
            } catch (Exception e) {
                log.warn(e.getMessage());
            }
        }

        return 1;
    }

    public List<BrokerPlacedOrder> getBrokerPlacedOrdersFromClassPathFile(String fileName) throws Exception {
        String jsonString = FileUtil.readFileByClasspath(fileName);
        BrokerBuyResponse brokerBuyResponse = JsonUtil.convertToObject(
            jsonString, BrokerBuyResponse.class);

        List<BrokerBuyResponseData> stockResponseDataList = brokerBuyResponse.getStockResponseDataList();
        return stockResponseDataList.get(0).getBrokerPlacedOrderList();
    }
}
