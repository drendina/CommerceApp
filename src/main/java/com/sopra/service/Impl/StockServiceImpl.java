package com.sopra.service.Impl;

import com.sopra.dao.StockDAO;
import com.sopra.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDAO stockDAO;
    @Override
    public void updateStock(int[] stockUpdate) {
        stockDAO.updateStock(stockUpdate);
    }
}
