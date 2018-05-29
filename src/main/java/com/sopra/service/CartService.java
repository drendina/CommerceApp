package com.sopra.service;

import com.sopra.model.Cart;

import java.util.List;

public interface CartService {
     void createAndInsertInto (int idSku, int idCart);
     void createCartBindWithUser (int idUser);
     Cart getCartById (int idUser);
     List getProductList(int idUser);
     int getCartQty (int idCart);
     void deleteItems(List skuCartList);
}
