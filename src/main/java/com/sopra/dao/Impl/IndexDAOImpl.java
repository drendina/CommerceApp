package com.sopra.dao.Impl;

import com.sopra.dao.IndexDAO;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class IndexDAOImpl implements IndexDAO {
    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(IndexDAO.class);

    @Override
    public List getAllProduct() {
        logger.info("getAllProduct");
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Product")
                .list();
    }
}
