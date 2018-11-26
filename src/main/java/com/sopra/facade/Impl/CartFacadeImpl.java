package com.sopra.facade.Impl;

import com.sopra.data.CartData;
import com.sopra.data.CartPageData;
import com.sopra.facade.CartFacade;
import com.sopra.model.Cart;
import com.sopra.service.CartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public void removeFromCart(int idSku, int idCart) {
        cartService.removeFromCart(idSku, idCart);
    }

    @Override
    public int getCartQty (int idCart) {
        logger.info("Get cart quantity from cart: " + idCart);
        return cartService.getCartQty(idCart);
    }

    @Override
    public CartData getCartByid(int idUser) {
        Cart temp = cartService.getCartById(idUser);
        return new CartData(temp.getIdCart(), temp.getAmount(), temp.getIdUser());
    }

    @Override
    public List getProductList(int idUser) {
        return cartService.getProductList(idUser);
    }

    @Override
    public void deleteItems(List skuCartList) {
        cartService.deleteItems(skuCartList);
    }

    @Override
    public List<CartPageData> getCart(int idUser) {
        return cartService.getCart(idUser);
    }

    @Override
    public int getTotal(List<CartPageData> itemList) {
        return cartService.getTotal(itemList);
    }
}
