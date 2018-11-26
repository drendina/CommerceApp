package com.sopra.service;

import com.sopra.data.ProductData;
import com.sopra.model.Product;

import java.util.List;

public interface ProductService {
    List getAllProduct();
    Product getProductById(int idProduct);
    List<Product> getListProductByGenderAndCategory (String gender, String category);
    void insertProduct(ProductData productData);
}

