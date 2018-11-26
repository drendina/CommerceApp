package com.sopra.facade.Impl;

import com.sopra.facade.SkuFacade;
import com.sopra.model.Sku;
import com.sopra.service.OrderService;
import com.sopra.service.SkuService;
import com.sopra.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SkuFacadeImpl implements SkuFacade {

    @Autowired
    private SkuService skuService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private StockService stockService;


    @Override
    public Sku retrieveSkuById(int idProduct) {
        return skuService.retrieveSkuByIdProduct(idProduct);
    }

    @Override
    public List getSkuDataList(int idProduct) {
        return  skuService.getListSkuById(idProduct);
    }

    @Override
    public void insertItems(List skuOrderList) {
        orderService.insertItems(skuOrderList);
    }

    @Override
    public void updateStock(int[] stockUpdate) {
        stockService.updateStock(stockUpdate);
    }
}
