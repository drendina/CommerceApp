package com.sopra.controller;

import com.sopra.data.CartPageData;
import com.sopra.data.UserData;
import com.sopra.facade.CartFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
@RequestMapping(value = "/checkout")
public class CheckoutController {

    private static final Logger logger = Logger.getLogger(CheckoutController.class);

    @Autowired
    private CartFacade cartFacade;

    @RequestMapping(value = {"", "/"})
    public ModelAndView checkout(HttpSession session) {
        logger.info("Checkout page");
        List<CartPageData> itemList = cartFacade.getCart(((UserData) session.getAttribute("loggedUser")).getIdUser());
        return new ModelAndView("checkoutPage", "itemList" , itemList)
                .addObject("totalPrice", cartFacade.getTotal(itemList));
    }
}
