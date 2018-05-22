package com.sopra.dao.Impl;

import com.sopra.dao.CartDAO;
import com.sopra.model.Cart;
import com.sopra.model.SkuCart;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public void createCartBindWithUser(int idUser) {
        sessionFactory.getCurrentSession().persist(new Cart(idUser));
    }

    @Override
    public Cart getCartById(int idUser) {
        Cart temp = (Cart) sessionFactory.getCurrentSession()
                .createQuery("FROM Cart C WHERE C.idUser = :idUser")
                .setParameter("idUser", idUser)
                .list()
                .get(0);


        logger.info("Find cart: " +temp);
        return temp;
    }
    @Override
    public List getProductList(int idUser) {
        //TODO REFACTOR, RICHAIMARE METODO SOPRA

        Cart temp = (Cart) sessionFactory.getCurrentSession()
                .createQuery("FROM Cart C WHERE C.idUser = :idUser")
                .setParameter("idUser", idUser)
                .list()
                .get(0);

        logger.info("Find cart: " +temp);

        int idCartFind = temp.getIdCart();
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Product P, Sku S, SkuCart SC WHERE SC.idCart = :idCart AND SC.idSku = S.idSku AND S.baseProduct = P.idProduct")
                .setParameter("idCart", idCartFind).list();
    }
}
