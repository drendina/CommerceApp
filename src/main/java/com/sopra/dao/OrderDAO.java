package com.sopra.dao;

import com.sopra.model.Order;

import java.util.List;

public interface OrderDAO {
    int insertOrder(Order order);
    void insertItems(List skuOrderList);
}
