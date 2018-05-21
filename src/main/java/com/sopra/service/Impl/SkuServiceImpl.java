package com.sopra.service.Impl;

import com.sopra.dao.SkuDAO;
import com.sopra.model.Sku;
import com.sopra.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuDAO skuDAO;

    @Override
    public Sku retrieveSkuByIdProduct(int idProduct) {
        return skuDAO.retrieveSkuById(idProduct);
    }

    @Override
    public List getListSkuById(int idProduct) {
        return skuDAO.getListSkuById(idProduct);
    }
}
