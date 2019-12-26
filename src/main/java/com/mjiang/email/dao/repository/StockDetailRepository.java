package com.mjiang.email.dao.repository;

import java.math.BigDecimal;

import com.mjiang.email.model.MashDatum;
import com.mjiang.email.util.DateUtil;
import org.springframework.stereotype.Repository;

import static com.mjiang.email.jooq.domain.tables.StockInfoBack.STOCK_INFO_BACK;
import static com.mjiang.email.jooq.domain.tables.StockInfoFront.STOCK_INFO_FRONT;
import static com.mjiang.email.jooq.domain.tables.StockInfoNo.STOCK_INFO_NO;

@Repository
public class StockDetailRepository extends BaseRepository {

    public void insertMashDatumNo(String stockCode, MashDatum mashDatum) {
        /**
         * This set style is preferred way of insert statement
         */
        context.insertInto(STOCK_INFO_NO)
               .set(STOCK_INFO_NO.STOCK_CODE, stockCode)
               .set(STOCK_INFO_NO.TS_DATE, DateUtil.localDateToDate(mashDatum.getDate()))
               .set(STOCK_INFO_NO.OPEN, mashDatum.getKline().getOpen())
               .set(STOCK_INFO_NO.HIGH, mashDatum.getKline().getHigh())
               .set(STOCK_INFO_NO.LOW, mashDatum.getKline().getLow())
               .set(STOCK_INFO_NO.CLOSE, mashDatum.getKline().getClose())
               .set(STOCK_INFO_NO.VOLUME, BigDecimal.valueOf(mashDatum.getKline().getVolume()))
               .set(STOCK_INFO_NO.AMOUNT, BigDecimal.valueOf(mashDatum.getKline().getAmount()))
               .set(STOCK_INFO_NO.CCL, mashDatum.getKline().getCcl())
               .set(STOCK_INFO_NO.PRECLOSE, mashDatum.getKline().getPreClose())
               .set(STOCK_INFO_NO.NETCHANGERATIO, mashDatum.getKline().getNetChangeRatio())
               .set(STOCK_INFO_NO.MA5_VOLUME, BigDecimal.valueOf(mashDatum.getMa5().getVolume()))
               .set(STOCK_INFO_NO.MA5_AVGPRICE, mashDatum.getMa5().getAvgPrice())
               .set(STOCK_INFO_NO.MA5_CCL, mashDatum.getMa5().getCcl())
               .set(STOCK_INFO_NO.MA10_VOLUME, BigDecimal.valueOf(mashDatum.getMa10().getVolume()))
               .set(STOCK_INFO_NO.MA10_AVGPRICE, mashDatum.getMa10().getAvgPrice())
               .set(STOCK_INFO_NO.MA10_CCL, mashDatum.getMa10().getCcl())
               .set(STOCK_INFO_NO.MA20_VOLUME, BigDecimal.valueOf(mashDatum.getMa20().getVolume()))
               .set(STOCK_INFO_NO.MA20_AVGPRICE, mashDatum.getMa20().getAvgPrice())
               .set(STOCK_INFO_NO.MA20_CCL, mashDatum.getMa20().getCcl())
               .set(STOCK_INFO_NO.MACD_DIFF, mashDatum.getMacd().getDiff())
               .set(STOCK_INFO_NO.MACD_DEA, mashDatum.getMacd().getDea())
               .set(STOCK_INFO_NO.MACD, mashDatum.getMacd().getMacd())
               .set(STOCK_INFO_NO.KDJ_K, mashDatum.getKdj().getK())
               .set(STOCK_INFO_NO.KDJ_D, mashDatum.getKdj().getD())
               .set(STOCK_INFO_NO.KDJ_J, mashDatum.getKdj().getJ())
               .set(STOCK_INFO_NO.RSI1, mashDatum.getRsi().getRsi1())
               .set(STOCK_INFO_NO.RSI2, mashDatum.getRsi().getRsi2())
               .set(STOCK_INFO_NO.RSI3, mashDatum.getRsi().getRsi3())
               .execute();
    }

    public void insertMashDatumFront(String stockCode, MashDatum mashDatum) {
        /**
         * This set style is preferred way of insert statement
         */
        context.insertInto(STOCK_INFO_FRONT)
               .set(STOCK_INFO_FRONT.STOCK_CODE, stockCode)
               .set(STOCK_INFO_FRONT.TS_DATE, DateUtil.localDateToDate(mashDatum.getDate()))
               .set(STOCK_INFO_FRONT.OPEN, mashDatum.getKline().getOpen())
               .set(STOCK_INFO_FRONT.HIGH, mashDatum.getKline().getHigh())
               .set(STOCK_INFO_FRONT.LOW, mashDatum.getKline().getLow())
               .set(STOCK_INFO_FRONT.CLOSE, mashDatum.getKline().getClose())
               .set(STOCK_INFO_FRONT.VOLUME, BigDecimal.valueOf(mashDatum.getKline().getVolume()))
               .set(STOCK_INFO_FRONT.AMOUNT, BigDecimal.valueOf(mashDatum.getKline().getAmount()))
               .set(STOCK_INFO_FRONT.CCL, mashDatum.getKline().getCcl())
               .set(STOCK_INFO_FRONT.PRECLOSE, mashDatum.getKline().getPreClose())
               .set(STOCK_INFO_FRONT.NETCHANGERATIO, mashDatum.getKline().getNetChangeRatio())
               .set(STOCK_INFO_FRONT.MA5_VOLUME, BigDecimal.valueOf(mashDatum.getMa5().getVolume()))
               .set(STOCK_INFO_FRONT.MA5_AVGPRICE, mashDatum.getMa5().getAvgPrice())
               .set(STOCK_INFO_FRONT.MA5_CCL, mashDatum.getMa5().getCcl())
               .set(STOCK_INFO_FRONT.MA10_VOLUME, BigDecimal.valueOf(mashDatum.getMa10().getVolume()))
               .set(STOCK_INFO_FRONT.MA10_AVGPRICE, mashDatum.getMa10().getAvgPrice())
               .set(STOCK_INFO_FRONT.MA10_CCL, mashDatum.getMa10().getCcl())
               .set(STOCK_INFO_FRONT.MA20_VOLUME, BigDecimal.valueOf(mashDatum.getMa20().getVolume()))
               .set(STOCK_INFO_FRONT.MA20_AVGPRICE, mashDatum.getMa20().getAvgPrice())
               .set(STOCK_INFO_FRONT.MA20_CCL, mashDatum.getMa20().getCcl())
               .set(STOCK_INFO_FRONT.MACD_DIFF, mashDatum.getMacd().getDiff())
               .set(STOCK_INFO_FRONT.MACD_DEA, mashDatum.getMacd().getDea())
               .set(STOCK_INFO_FRONT.MACD, mashDatum.getMacd().getMacd())
               .set(STOCK_INFO_FRONT.KDJ_K, mashDatum.getKdj().getK())
               .set(STOCK_INFO_FRONT.KDJ_D, mashDatum.getKdj().getD())
               .set(STOCK_INFO_FRONT.KDJ_J, mashDatum.getKdj().getJ())
               .set(STOCK_INFO_FRONT.RSI1, mashDatum.getRsi().getRsi1())
               .set(STOCK_INFO_FRONT.RSI2, mashDatum.getRsi().getRsi2())
               .set(STOCK_INFO_FRONT.RSI3, mashDatum.getRsi().getRsi3())
               .execute();
    }

    public void insertMashDatumBack(String stockCode, MashDatum mashDatum) {
        /**
         * This set style is preferred way of insert statement
         */
        context.insertInto(STOCK_INFO_BACK)
               .set(STOCK_INFO_BACK.STOCK_CODE, stockCode)
               .set(STOCK_INFO_BACK.TS_DATE, DateUtil.localDateToDate(mashDatum.getDate()))
               .set(STOCK_INFO_BACK.OPEN, mashDatum.getKline().getOpen())
               .set(STOCK_INFO_BACK.HIGH, mashDatum.getKline().getHigh())
               .set(STOCK_INFO_BACK.LOW, mashDatum.getKline().getLow())
               .set(STOCK_INFO_BACK.CLOSE, mashDatum.getKline().getClose())
               .set(STOCK_INFO_BACK.VOLUME, BigDecimal.valueOf(mashDatum.getKline().getVolume()))
               .set(STOCK_INFO_BACK.AMOUNT, BigDecimal.valueOf(mashDatum.getKline().getAmount()))
               .set(STOCK_INFO_BACK.CCL, mashDatum.getKline().getCcl())
               .set(STOCK_INFO_BACK.PRECLOSE, mashDatum.getKline().getPreClose())
               .set(STOCK_INFO_BACK.NETCHANGERATIO, mashDatum.getKline().getNetChangeRatio())
               .set(STOCK_INFO_BACK.MA5_VOLUME, BigDecimal.valueOf(mashDatum.getMa5().getVolume()))
               .set(STOCK_INFO_BACK.MA5_AVGPRICE, mashDatum.getMa5().getAvgPrice())
               .set(STOCK_INFO_BACK.MA5_CCL, mashDatum.getMa5().getCcl())
               .set(STOCK_INFO_BACK.MA10_VOLUME, BigDecimal.valueOf(mashDatum.getMa10().getVolume()))
               .set(STOCK_INFO_BACK.MA10_AVGPRICE, mashDatum.getMa10().getAvgPrice())
               .set(STOCK_INFO_BACK.MA10_CCL, mashDatum.getMa10().getCcl())
               .set(STOCK_INFO_BACK.MA20_VOLUME, BigDecimal.valueOf(mashDatum.getMa20().getVolume()))
               .set(STOCK_INFO_BACK.MA20_AVGPRICE, mashDatum.getMa20().getAvgPrice())
               .set(STOCK_INFO_BACK.MA20_CCL, mashDatum.getMa20().getCcl())
               .set(STOCK_INFO_BACK.MACD_DIFF, mashDatum.getMacd().getDiff())
               .set(STOCK_INFO_BACK.MACD_DEA, mashDatum.getMacd().getDea())
               .set(STOCK_INFO_BACK.MACD, mashDatum.getMacd().getMacd())
               .set(STOCK_INFO_BACK.KDJ_K, mashDatum.getKdj().getK())
               .set(STOCK_INFO_BACK.KDJ_D, mashDatum.getKdj().getD())
               .set(STOCK_INFO_BACK.KDJ_J, mashDatum.getKdj().getJ())
               .set(STOCK_INFO_BACK.RSI1, mashDatum.getRsi().getRsi1())
               .set(STOCK_INFO_BACK.RSI2, mashDatum.getRsi().getRsi2())
               .set(STOCK_INFO_BACK.RSI3, mashDatum.getRsi().getRsi3())
               .execute();
    }

}
