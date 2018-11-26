package com.sopra.dao.Impl;

import com.sopra.dao.SkuDAO;
import com.sopra.model.Sku;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SkuDAOImpl implements SkuDAO {
    private static final Logger logger = Logger.getLogger(SkuDAO.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Sku retrieveSkuById(int idProduct) {
        logger.info("retrieveSkuByIdProduct");
        return (Sku) sessionFactory.getCurrentSession()
                .createQuery("FROM Sku S WHERE S.baseProduct = :idProduct")
                .setParameter("idProduct", idProduct)
                .list()
                .get(0);
    }

    @Override
    public List getListSkuById(int idProduct) {
        return  sessionFactory.getCurrentSession()
                .createQuery("FROM Sku S WHERE S.baseProduct = :idProduct")
                .setParameter("idProduct", idProduct)
                .list();
    }

    @Override
    public Sku getSkuBy_IdSku(int idSku) {
        return (Sku) sessionFactory.getCurrentSession()
                .createQuery("from Sku where idSku = :idSku")
                .setParameter("idSku", idSku)
                .list().get(0);

    }
}
