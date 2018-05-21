package com.sopra.service;

import com.sopra.model.Sku;

import java.util.List;

public interface SkuService {
    Sku retrieveSkuByIdProduct(int idProduct);
    List getListSkuById (int idProduct);
}
