package com.sopra.dao.Impl;

import com.sopra.dao.StockDAO;
import com.sopra.model.Stock;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class StockDAOImpl implements StockDAO {
    private static final Logger logger = Logger.getLogger(StockDAO.class);
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void updateStock(int[] stockUpdate) {
        for(int i = 0; i < stockUpdate.length; i++){
            int idSkuFromArray = stockUpdate[i];
            Stock tempStock =(Stock) sessionFactory.getCurrentSession()
                .createQuery("FROM Stock S WHERE S.idSku = :id")
                .setParameter("id", idSkuFromArray)
                .list()
                .get(0);
            logger.info("Updating Stock");
//            int newRemaining = tempStock.getRemainingItems() - 1;
//            int idStock = tempStock.getIdStock();

//            Stock stockTemp = (Stock)sessionFactory.getCurrentSession()
//                    .get(Stock.class, stockUpdate[i]);
            tempStock.setRemainingItems(tempStock.getRemainingItems()-1);
            sessionFactory.getCurrentSession().update(tempStock);
        }
    }
}
