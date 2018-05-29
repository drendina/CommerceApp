package com.sopra.facade;

import com.sopra.data.CartData;

import java.util.List;

public interface CartFacade {
    void addToCart (int idSku, int idCart);
    int getCartQty (int idCart);
    CartData getCartByid (int idUser);
    List getProductList(int idUser);
    void deleteItems(List skuCartList);
}
