package com.sopra.facade.Impl;

import com.sopra.facade.SkuFacade;
import com.sopra.model.Sku;
import com.sopra.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class SkuFacadeImpl implements SkuFacade {

    @Autowired
    private SkuService skuService;

    @Override
    public Sku retrieveSkuById(int idProduct) {
        return skuService.retrieveSkuById(idProduct);
    }
}
