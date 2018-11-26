package com.sopra.facade;

import com.sopra.data.ProductData;
import com.sopra.model.Product;

import java.util.List;

public interface ProductFacade {
    ProductData getProductDataById(int idProduct);
    List getAllProduct();

    Product getProductById(int idProduct);
    void insertProduct(ProductData productData);
    List getAllProductsByCategoryAndGender(String gender, String category);
}
