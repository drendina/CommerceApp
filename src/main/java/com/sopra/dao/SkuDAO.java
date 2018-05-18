package com.sopra.dao;

import com.sopra.model.Sku;

public interface SkuDAO {
    Sku retrieveSkuById(int idProduct);
}
