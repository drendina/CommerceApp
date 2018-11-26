package com.sopra.service;

import com.sopra.model.Order;

import java.util.List;

public interface OrderService {
    int insertOrder (Order order);
    void insertItems(List skuOrderList);
    List<Order> getOrders(int idUser);

}
