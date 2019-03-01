package com.mjiang.email.service;

import com.mjiang.email.dao.repository.StockDetailRepository;
import com.mjiang.email.model.MashDatum;
import com.mjiang.email.model.StockDetailInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockDetailService {

    private static final Logger log = LoggerFactory.getLogger(StockDetailService.class);

    @Autowired
    private StockDetailRepository stockDetailRepository;

    @Transactional
    public int insertStockDetailInfoNo(StockDetailInfo stockDetailInfo) {
        String stockCode = stockDetailInfo.getStockCode();
        int count = 0;

        try {
            for (MashDatum mashDatum : stockDetailInfo.getMashData()) {
                this.insertMashDatumNo(stockCode, mashDatum);
                count++;
            }
        } catch (DuplicateKeyException e) {
            log.warn(e.getMessage());
        }

        return count;
    }

    @Transactional
    public int insertStockDetailInfoFront(StockDetailInfo stockDetailInfo) {
        String stockCode = stockDetailInfo.getStockCode();
        int count = 0;

        try {
            for (MashDatum mashDatum : stockDetailInfo.getMashData()) {
                this.insertMashDatumFront(stockCode, mashDatum);
                count++;
            }
        } catch (DuplicateKeyException e) {
            log.warn(e.getMessage());
        }

        return count;
    }

    @Transactional
    public int insertStockDetailInfoBack(StockDetailInfo stockDetailInfo) {
        String stockCode = stockDetailInfo.getStockCode();
        int count = 0;

        try {
            for (MashDatum mashDatum : stockDetailInfo.getMashData()) {
                this.insertMashDatumBack(stockCode, mashDatum);
                count++;
            }
        } catch (DuplicateKeyException e) {
            log.warn(e.getMessage());
        }

        return count;
    }

    @Transactional
    public int insertMashDatumNo(String stockCode, MashDatum mashDatum) {
        int count = 0;

        try {
            stockDetailRepository.insertMashDatumNo(stockCode, mashDatum);
            count++;
        } catch (DuplicateKeyException e) {
            log.warn(e.getMessage());
        }

        return count;
    }

    @Transactional
    public int insertMashDatumFront(String stockCode, MashDatum mashDatum) {
        int count = 0;

        try {
            stockDetailRepository.insertMashDatumFront(stockCode, mashDatum);
            count++;
        } catch (DuplicateKeyException e) {
            log.warn(e.getMessage());
        }

        return count;
    }

    @Transactional
    public int insertMashDatumBack(String stockCode, MashDatum mashDatum) {
        int count = 0;

        try {
            stockDetailRepository.insertMashDatumBack(stockCode, mashDatum);
            count++;
        } catch (DuplicateKeyException e) {
            log.warn(e.getMessage());
        }

        return count;
    }
}
