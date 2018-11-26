package com.sopra.dao.Impl;

import com.sopra.dao.ProductDAO;
import com.sopra.data.ProductData;
import com.sopra.model.Product;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public List<Product> getListProductByGenderAndCategory(String gender, String category) {
        return (List<Product>) sessionFactory.getCurrentSession()
                .createQuery("from Product P where P.gender = :gender and P.category = :category ")
                .setParameter("gender", gender)
                .setParameter("category", category)
                .list();
    }

    @Override
    public void insertProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public List getAllProduct() {
       return sessionFactory.getCurrentSession()
                .createQuery("FROM Product")
                .list();
    }

}

