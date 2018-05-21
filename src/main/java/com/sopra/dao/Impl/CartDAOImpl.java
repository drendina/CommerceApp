package com.sopra.dao.Impl;

import com.sopra.dao.CartDAO;
import com.sopra.model.SkuCart;
import com.sopra.model.Cart;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

    private static final Logger logger = Logger.getLogger(CartDAO.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createCart() {
        logger.info("create cart");
        Cart cart = new Cart(1);
        sessionFactory.getCurrentSession()
            .persist(cart);
    }

    @Override
    public void insertInto(int idSku, int idCart) {
        logger.info("insert into");
        SkuCart temp = new SkuCart(idSku, idCart);
        sessionFactory.getCurrentSession()
                .persist(temp);
    }
}
