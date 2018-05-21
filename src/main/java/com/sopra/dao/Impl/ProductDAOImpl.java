package com.sopra.dao.Impl;

import com.sopra.dao.ProductDAO;
import com.sopra.model.Product;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {
    private static final Logger logger = Logger.getLogger(ProductDAO.class);

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Product getProductById(int idProduct) {
    logger.info("retrieveProductById");

    return (Product) sessionFactory.getCurrentSession()
            .createQuery("FROM Product P WHERE P.idProduct = :idProduct")
            .setParameter("idProduct", idProduct)
            .list()
            .get(0);

    }
}
