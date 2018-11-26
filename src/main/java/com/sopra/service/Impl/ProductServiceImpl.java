package com.sopra.service.Impl;

import com.sopra.dao.ProductDAO;
import com.sopra.data.ProductData;
import com.sopra.model.Product;
import com.sopra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public Product getProductById(int idProduct) {
        return productDAO.getProductById(idProduct);
    }

    @Override
    public List<Product> getListProductByGenderAndCategory(String gender, String category) {
        return productDAO.getListProductByGenderAndCategory(gender,category);
    }

    @Override
    public void insertProduct(ProductData productData) {
        Product product = new Product(productData.getCode(),productData.getDescription(),productData.getName(),productData.getImage(),productData.getColore(),productData.getTessuto(),productData.getCategory(),productData.getGender());
        productDAO.insertProduct(product);
    }
    @Override
    public List getAllProduct(){
        return productDAO.getAllProduct();
    }
}
