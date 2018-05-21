package com.sopra.facade.Impl;

import com.sopra.data.ProductData;
import com.sopra.facade.ProductDataFacade;
import com.sopra.model.Product;
import com.sopra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductDataFacadeImpl implements ProductDataFacade {

    @Autowired
    private ProductService productService;
    @Override
    public ProductData getProductDataById(int idProduct) {
       Product productTemp = productService.getProductById(idProduct);
       return new ProductData(idProduct,
               productTemp.getDescription(),
               productTemp.getName(),
               productTemp.getImage(),
               productTemp.getColore(),
               productTemp.getTessuto());

    }
}
