package com.sopra.dao;

import com.sopra.data.ProductData;
import com.sopra.model.Product;

import java.util.List;

public interface ProductDAO {
    List getAllProduct();
    Product getProductById(int id);
    List<Product> getListProductByGenderAndCategory(String gender, String category);
    void insertProduct(Product product);
}
