package com.sopra.service.Impl;

import com.sopra.dao.OrderDAO;
import com.sopra.model.Order;
import com.sopra.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public int insertOrder(Order order) {
    return orderDAO.insertOrder(order);
    }

    @Override
    public void insertItems(List skuOrderList) {
        orderDAO.insertItems(skuOrderList);
    }

    @Override
    public List<Order> getOrders(int idUser) {
        List<Order> orderList = orderDAO.getOrdersByIdUser(idUser);
        return null;
    }
}
