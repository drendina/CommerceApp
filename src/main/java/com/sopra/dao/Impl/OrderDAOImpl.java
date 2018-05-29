package com.sopra.dao.Impl;

import com.sopra.dao.OrderDAO;
import com.sopra.model.Order;
import com.sopra.model.SkuOrder;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrderDAOImpl  implements OrderDAO {

    private static final Logger logger = Logger.getLogger(OrderDAO.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int insertOrder(Order order) {
        logger.info("Order: " + order);
        return (int) sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public void insertItems(List skuOrderList) {
        int length = skuOrderList.size();
        for (int i = 0; i < length; i++){
            SkuOrder temp = (SkuOrder) (skuOrderList.get(i));
            sessionFactory.getCurrentSession().save(temp);
        }
    }
}
