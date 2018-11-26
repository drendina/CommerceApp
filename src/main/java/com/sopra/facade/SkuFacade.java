package com.sopra.facade;

import com.sopra.model.Sku;

import java.util.List;

public interface SkuFacade {

    Sku retrieveSkuById(int id);
    List getSkuDataList (int idProduct);

    void insertItems(List skuOrderList);

    void updateStock(int[] stockUpdate);
}
