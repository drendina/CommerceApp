package com.sopra.dao;

import com.sopra.model.Cart;

import java.util.List;

public interface CartDAO {
    void createCart();
    void insertInto(int idSku, int idCart);
    void createCartBindWithUser(int idUser);
    Cart getCartById(int idUser);
    List getProductList(int idUser);
    int getCartQty(int idCart);
}
