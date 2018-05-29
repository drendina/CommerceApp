package com.sopra.facade.Impl;

import com.sopra.facade.SkuOrderFacade;
import com.sopra.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SkuOrderFacadeImpl implements SkuOrderFacade {
    @Autowired
    private OrderService orderService;

    private static final Logger logger = Logger.getLogger(SkuOrderFacade.class);

    @Override
    public void insertItems(List skuOrderList) {
        logger.info("inserting items");
        orderService.insertItems(skuOrderList);

    }
}
