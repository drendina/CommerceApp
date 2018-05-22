package com.sopra.service.Impl;

import com.sopra.dao.CartDAO;
import com.sopra.model.Cart;
import com.sopra.service.CartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CartServiceImpl implements CartService {
    private static final Logger logger = Logger.getLogger(CartService.class);

    @Autowired
    private CartDAO cartDAO;

    @Override
    public void createAndInsertInto(int idSku, int idCart) {
        logger.info("create cart");
        cartDAO.createCart();
        cartDAO.insertInto(idSku, idCart);
    }

    @Override
    public void createCartBindWithUser(int idUser) {
        cartDAO.createCartBindWithUser(idUser);
    }

    @Override
    public Cart getCartById(int idUser) {
        return cartDAO.getCartById(idUser);
    }

    @Override
    public List getProductList(int idUser) {
        return cartDAO.getProductList(idUser);
    }
}
