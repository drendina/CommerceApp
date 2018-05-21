package com.sopra.dao;

public interface CartDAO {
    void createCart();
    void insertInto(int idSku, int idCart);
}
