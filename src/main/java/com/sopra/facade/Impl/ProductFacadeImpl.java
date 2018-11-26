package com.sopra.facade.Impl;

import com.sopra.data.ProductData;
import com.sopra.facade.ProductFacade;
import com.sopra.model.Product;
import com.sopra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductFacadeImpl implements ProductFacade {

    @Autowired
    private ProductService productService;

    @Override
    public ProductData getProductDataById(int idProduct) {
        Product productTemp = productService.getProductById(idProduct);
        return new ProductData(
                productTemp.getCode(),
                productTemp.getDescription(),
                productTemp.getName(),
                productTemp.getImage(),
                productTemp.getColore(),
                productTemp.getTessuto(),
                productTemp.getCategory(),
                productTemp.getGender());
    }

    @Override
    public Product getProductById(int idProduct) {
        return productService.getProductById(idProduct);
    }

    @Override
    public void insertProduct(ProductData productData) {
        productService.insertProduct(productData);
    }

    @Override
    public List getAllProductsByCategoryAndGender(String gender, String category) {
        return productService.getListProductByGenderAndCategory(gender, category);
    }

    public List getAllProduct(){
        return productService.getAllProduct();
    }
}
