package com.sopra.facade.Impl;

import com.sopra.facade.OrderFacade;
import com.sopra.model.Order;
import com.sopra.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderFacadeImpl implements OrderFacade {

    @Autowired
    private OrderService orderService;
    @Override
    public int insertOrder(String nowDate, int idUser, int amount) {
        Order order = new Order (nowDate, idUser, amount);
        return orderService.insertOrder(order);
    }
}
