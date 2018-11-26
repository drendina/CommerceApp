package com.sopra.dao.Impl;

import com.sopra.dao.CartDAO;
import com.sopra.dao.ProductDAO;
import com.sopra.dao.SkuDAO;
import com.sopra.data.CartPageData;
import com.sopra.data.ProductSkuData;
import com.sopra.model.Cart;
import com.sopra.model.Product;
import com.sopra.model.Sku;
import com.sopra.model.SkuCart;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

    private static final Logger logger = Logger.getLogger(CartDAO.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SkuDAO skuDAO;

    @Autowired
    private ProductDAO productDAO;

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
    public void removeFromCart(int idSku, int idCart) {
        sessionFactory.getCurrentSession().delete( sessionFactory.getCurrentSession()
                .createQuery("from SkuCart where idSku = :idSku and idCart = :idCart")
                .setParameter("idSku" , idSku)
                .setParameter("idCart", idCart)
                .list().get(0) );
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


        logger.info("Find cart(getCartById): " +temp);
        return temp;
    }
//    @Override
//    public List getProductList(int idUser) {
//        Cart temp = getCartById(idUser);
//        logger.info("Find cart (getProductList): " +temp);
//        int idCartFind = temp.getIdCart();
//        return sessionFactory.getCurrentSession()
//                .createQuery("FROM Product P, Sku S, SkuCart SC WHERE SC.idCart = :idCart AND SC.idSku = S.idSku AND S.baseProduct = P.idProduct")
//                .setParameter("idCart", idCartFind).list();
//    }

    @Override
    public List getProductList (int idUser){
        int idCart = getCartById(idUser).getIdCart();
        /*return sessionFactory.getCurrentSession()
                .createQuery("FROM SkuCart SC WHERE SC.idCart = :idCart")
                .setParameter("idCart", idCart)
                .list();*/
        return sessionFactory.getCurrentSession()
                .createSQLQuery("SELECT * FROM sku as SK join product as PR on SK.baseProduct = PR.idProduct WHERE SK.idSku IN(SELECT idSku FROM sku_cart SC WHERE SC.idCart = :idCart)")
                .setParameter("idCart", idCart)
                .list();

    }

    @Override
    public int getCartQty(int idCart) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT COUNT(*) FROM SkuCart AS SC WHERE SC.idCart = :idCart")
                .setParameter("idCart", idCart);
        long temp = 0;
        for(Iterator it = query.iterate(); it.hasNext();) {
             temp = (Long) it.next();
        }
        logger.info("Numero elementi: " + temp);
        return (int)(long) temp;
    }

    @Override
    public void deleteItems(List skuCartList) {
        int length = skuCartList.size();
        for(int i = 0; i< length; i++)
        {
            SkuCart temp = (SkuCart) skuCartList.get(i);
            sessionFactory.getCurrentSession().delete(temp);
        }
    }

    @Override
    public List<CartPageData> getCart(int idUser) {

            logger.info("Prova");
            Cart cartTemp = (Cart) sessionFactory.getCurrentSession()
                    .createQuery("from Cart where idUser = :idU")
                    .setParameter("idU", idUser)
                    .list().get(0);

            List<SkuCart> skuCartTemp = (List<SkuCart>) sessionFactory.getCurrentSession()
                    .createQuery("from SkuCart where idCart = :idC")
                    .setParameter("idC", cartTemp.getIdCart())
                    .list();

            List<ProductSkuData> listPSdata = new ArrayList<>();

            for (SkuCart elm : skuCartTemp
                    ) {
                Sku S = skuDAO.getSkuBy_IdSku(elm.getIdSku());
                Product P = productDAO.getProductById(S.getBaseProduct());
                ProductSkuData PSD = new ProductSkuData(S.getIdSku(), P.getDescription(), P.getName(), P.getImage(), P.getColore(), P.getTessuto(), P.getCategory(), P.getGender(), S.getSize(), S.getPrice());
                logger.info(PSD);
                listPSdata.add(PSD);
            }

            List<CartPageData> listCartPageData = new ArrayList<>();

            for (ProductSkuData elm : listPSdata) {
                CartPageData temp = new CartPageData(elm.getIdSku(), elm.getName(), elm.getImage(), elm.getPrice(), 1, elm.getSize());
                if (listCartPageData.isEmpty()) {
                    listCartPageData.add(temp);
                } else{
                    Boolean added = false;

                    for(int i = 0; i < listCartPageData.size(); i++ ){
                        CartPageData cartPageData_temp = listCartPageData.get(i);

                        if(cartPageData_temp.getIdSku() == temp.getIdSku() && cartPageData_temp.getSize() == temp.getSize()){
                            cartPageData_temp.setCumulative_size_price(cartPageData_temp.getCumulative_size_price() + temp.getCumulative_size_price());
                            cartPageData_temp.setQuantity(cartPageData_temp.getQuantity() + 1);
                            added = true;
                            break;
                        }
                    }
                    if(!added){
                        listCartPageData.add(temp);
                    }


                }


                    /*for (CartPageData cpd : listCartPageData) {
                       // cpd.setCumulative_size_price(cpd.getCumulative_size_price() + temp.getCumulative_size_price());
                        if (cpd.getIdSku() == temp.getIdSku() && cpd.getSize() == temp.getSize()) {
                            cpd.setCumulative_size_price(cpd.getCumulative_size_price() + temp.getCumulative_size_price());
                            cpd.setQuantity(cpd.getQuantity() + 1);
                        } else
                            listCartPageData.add(temp);
                    }*/
            }

            return listCartPageData;


    }
}
