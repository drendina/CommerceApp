package com.sopra.facade.Impl;

import com.sopra.facade.CartFacade;
import com.sopra.service.CartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CartFacadeImpl implements CartFacade {
//    conterrà tutti i metodi di utilità per l'accesso al carrello: addtocart, removeitemfromcart getcart
//    getcart si dovrà occupare di chiamare i vari service del carrello e dei prodotti e degli altri eventuali
//    che restituiranno il model del carrello ed il model dei prodotti
//    questo metodo chiamerà degli oggetti (chiamati populator) che dato un model restituiranno il data corrispondente
//    in particolare avrai i model del carrello e dei prodotti fino al facade
//    il controller riceverà dal facade il cartData con dentro una lista di ItemData
    private static final Logger logger = Logger.getLogger(CartFacadeImpl.class);

    @Autowired
    private CartService cartService;
    @Override
    public void addToCart (int idSku, int idCart){
        logger.info("create and insert into");
        cartService.createAndInsertInto(idSku, idCart);
    }

}
