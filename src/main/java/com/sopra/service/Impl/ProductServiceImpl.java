package com.sopra.service.Impl;

import com.sopra.dao.ProductDAO;
import com.sopra.model.Product;
import com.sopra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public Product getProductById(int idProduct) {

        return productDAO.getProductById(idProduct);
    }
}
