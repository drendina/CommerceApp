package com.sopra.dao.Impl;

import com.sopra.dao.SkuDAO;
import com.sopra.model.Sku;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class SkuDAOImpl implements SkuDAO {
    private static final Logger logger = Logger.getLogger(SkuDAO.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Sku retrieveSkuById(int idProduct) {
        logger.info("retrieveSkuById");
        return (Sku) sessionFactory.getCurrentSession()
                .createQuery("FROM Sku S WHERE S.baseProduct = :idProduct")
                .setParameter("idProduct", idProduct)
                .list()
                .get(0);
    }
}
