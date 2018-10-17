package com.sopra.dao;

import com.sopra.model.Sku;

import java.util.List;

public interface SkuDAO {
    Sku retrieveSkuById(int idProduct);
    List getListSkuById(int idProduct);
}
