package com.sopra.facade.Impl;

import com.sopra.facade.ProductFacade;
import com.sopra.model.Product;
import com.sopra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductFacadeImpl implements ProductFacade {
    @Autowired
    private ProductService productService;

    @Override
    public Product getProductById(int idProduct) {
        return productService.getProductById(idProduct);
    }

}
