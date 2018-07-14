package com.mjiang.email.dao.repository;

import com.mjiang.email.model.BrokerPlacedOrder;
import com.mjiang.email.model.BrokerPlacedOrder.StockSummary;
import com.mjiang.email.util.DateUtil;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.mjiang.email.jooq.domain.Tables.BROKER_BUY_STOCK_INFO;
import static com.mjiang.email.jooq.domain.Tables.BROKER_BUY_SUMMARY;

@Repository
public class BrokerRepository extends BaseRepository {

    public long insertBrokerBuySummary(BrokerPlacedOrder brokerPlacedOrder) {

        Record record = context.insertInto(BROKER_BUY_SUMMARY,
                   BROKER_BUY_SUMMARY.BROKER_CODE,
                   BROKER_BUY_SUMMARY.BROKER_NAME,
                   BROKER_BUY_SUMMARY.S_MONEY,
                   BROKER_BUY_SUMMARY.B_MONEY,
                   BROKER_BUY_SUMMARY.JM_MONEY,
                   BROKER_BUY_SUMMARY.B_COUNT,
                   BROKER_BUY_SUMMARY.S_COUNT,
                   BROKER_BUY_SUMMARY.TS_DATE)
               .values(
                   brokerPlacedOrder.getBrokerCode(),
                   brokerPlacedOrder.getBrokerName(),
                   brokerPlacedOrder.getsMoney(),
                   brokerPlacedOrder.getbMoney(),
                   brokerPlacedOrder.getJmMoney(),
                   brokerPlacedOrder.getBrokerBuyCount(),
                   brokerPlacedOrder.getBrokerSellCount(),
                   DateUtil.localdateToDate(brokerPlacedOrder.getDate()))
               .returning(BROKER_BUY_SUMMARY.ID)
               .fetchOne();

        return record.get(BROKER_BUY_SUMMARY.ID);
    }

    public void insertBrokerBuyStockInfo(long brokerBuySummaryId, StockSummary stockSummary) {
        context.insertInto(BROKER_BUY_STOCK_INFO,
                    BROKER_BUY_STOCK_INFO.BROKER_BUY_SUMMARY_ID,
                    BROKER_BUY_STOCK_INFO.STOCK_CODE,
                    BROKER_BUY_STOCK_INFO.STOCK_NAME)
               .values(
                   brokerBuySummaryId,
                   stockSummary.getCode(),
                   stockSummary.getCodeName())
               .execute();
    }
}
