package com.sopra.controller;

import com.sopra.data.CartData;
import com.sopra.data.UserData;
import com.sopra.facade.CartFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
@RequestMapping(value = "/cart")
public class CartController {

    private static final Logger logger = Logger.getLogger(CartController.class);

    @Autowired
    private CartFacade cartFacade;
    @RequestMapping(value = "/")
    public ModelAndView deployCartpage(@ModelAttribute("user") UserData userData) {
        logger.info("Deploying Cartpage");
        //TODO RECUPERARE CARRELLO PER CURRENT USER
        CartData currentCart = cartFacade.getCartByid(userData.getIdUser());
        List itemList = cartFacade.getProductList(userData.getIdUser());

        ModelAndView mv = new ModelAndView("cartPage");
                mv.addObject("itemList", itemList);
                mv.addObject("cUrrentCart", currentCart);

        return mv;
    }

    @RequestMapping(value = "/checkout")
    public ModelAndView checkout() {
        logger.info("go to checkout page");
        return new ModelAndView("checkout");
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public ModelAndView addToCart(HttpSession session, @RequestParam int idSku) {
        logger.info("add to cart");
        int idUser = (int) session.getAttribute("idUser");
        CartData currentCart = cartFacade.getCartByid(idUser);
        int idCart = currentCart.getIdCart();
        cartFacade.addToCart(idSku, idCart);

        return new ModelAndView("index");
    }



}