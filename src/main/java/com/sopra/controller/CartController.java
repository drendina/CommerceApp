package com.sopra.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping(value = "/cart")
public class CartController {

    private static final Logger logger = Logger.getLogger(CartController.class);

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



}