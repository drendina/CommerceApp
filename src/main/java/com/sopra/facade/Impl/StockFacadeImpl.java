package com.sopra.facade.Impl;

import com.sopra.facade.StockFacade;
import com.sopra.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class StockFacadeImpl implements StockFacade {

    @Autowired
    private StockService stockService;

    @Override
    public void updateStock(int[] stockUpdate) {
        stockService.updateStock(stockUpdate);
    }
}
