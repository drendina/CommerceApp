package com.sopra.service.Impl;

import com.sopra.dao.SkuDAO;
import com.sopra.model.Sku;
import com.sopra.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuDAO skuDAO;

    @Override
    public Sku retrieveSkuById(int idProduct) {
        return skuDAO.retrieveSkuById(idProduct);
    }
}
