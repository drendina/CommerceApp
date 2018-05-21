package com.sopra.facade.Impl;

import com.sopra.data.ProductSkuData;
import com.sopra.facade.ProductSkuDataFacade;
import com.sopra.model.Product;
import com.sopra.model.Sku;
import com.sopra.service.ProductService;
import com.sopra.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductSkuDataFacadeImpl implements ProductSkuDataFacade {

    @Autowired
    private SkuService skuService;

    @Autowired
    private ProductService productService;

    @Override
    public ProductSkuData populateSkuDataById (int idProduct) {
        Sku skuTemp = skuService.retrieveSkuByIdProduct(idProduct);
        Product producTemp = productService.getProductById(idProduct);

        String styleNumber = String.valueOf(idProduct) + String.valueOf(skuTemp.getIdSku());
        ProductSkuData temp = new ProductSkuData(styleNumber,
                producTemp.getDescription(),
                producTemp.getName(),
                producTemp.getImage(),
                producTemp.getColore(),
                producTemp.getTessuto(),
                skuTemp.getSize(),
                skuTemp.getPrice());
        return temp;
    }
}
