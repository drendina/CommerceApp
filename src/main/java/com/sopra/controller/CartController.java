package com.sopra.controller;

import com.sopra.facade.CartFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView deployCartpage() {
        logger.info("Deploying Cartpage");
        return new ModelAndView("cartPage");
    }

    @RequestMapping(value = "/checkout")
    public ModelAndView checkout() {
        logger.info("go to checkout page");
        return new ModelAndView("checkout");
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public ModelAndView addToCart() {
        logger.info("add to cart");
        int idCart=6;
        int idSku = 1;
        cartFacade.addToCart(idSku, idCart);

        return new ModelAndView("index");
    }



}