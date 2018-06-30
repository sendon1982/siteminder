package com.mjiang.email.service;

import java.util.List;

import com.mjiang.email.dao.repository.BrokerRepository;
import com.mjiang.email.model.BrokerBuyResponse;
import com.mjiang.email.model.BrokerBuyResponseData;
import com.mjiang.email.model.BrokerPlacedOrder;
import com.mjiang.email.model.BrokerPlacedOrder.StockSummary;
import com.mjiang.email.util.FileUtil;
import com.mjiang.email.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrokerService {

    @Autowired
    private BrokerRepository brokerRepository;

    @Transactional
    public void insertBrokerPlacedOrders(List<BrokerPlacedOrder> brokerPlacedOrders) {
        for (BrokerPlacedOrder brokerPlacedOrder : brokerPlacedOrders) {
            insertBrokerPlacedOrder(brokerPlacedOrder);
        }
    }

    @Transactional
    public void insertBrokerPlacedOrder(BrokerPlacedOrder brokerPlacedOrder) {
        long brokerBuySummaryId = brokerRepository.insertBrokerBuySummary(brokerPlacedOrder);

        for (StockSummary stockSummary : brokerPlacedOrder.getStockSummaryList()) {
            brokerRepository.insertBrokerBuyStockInfo(brokerBuySummaryId, stockSummary);
        }
    }

    public List<BrokerPlacedOrder> getBrokerPlacedOrdersFromClassPathFile(String fileName) throws Exception {
        String jsonString = FileUtil.readFileByClasspath(fileName);
        BrokerBuyResponse brokerBuyResponse = JsonUtil.convertToObject(
            jsonString, BrokerBuyResponse.class);

        List<BrokerBuyResponseData> stockResponseDataList = brokerBuyResponse.getStockResponseDataList();
        return stockResponseDataList.get(0).getBrokerPlacedOrderList();
    }
}
