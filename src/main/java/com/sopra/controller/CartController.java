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
    public ModelAndView deployCartpage(HttpSession session, @ModelAttribute("user") UserData userData) {
        logger.info("Deploying Cartpage");
        logger.info(session.getAttribute("loggedUser"));
//        TODO RECUPERARE CARRELLO PER CURRENT USER

        int idUser = ((UserData) session.getAttribute("loggedUser")).getIdUser();
        CartData currentCart = cartFacade.getCartByid(idUser);
        List itemList = cartFacade.getProductList(idUser);

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

    @RequestMapping(value = "/addToCart", method = RequestMethod.GET)
    public String addToCart(HttpSession session, @RequestParam int idSku) {
        logger.info("Add to cart  - idSku: " + idSku);
        UserData UserDataTEMP = (UserData)session.getAttribute("loggedUser");
        logger.info(UserDataTEMP);
        int idUser = UserDataTEMP.getIdUser();
       logger.info("idUser: " + idUser);
        CartData currentCart = cartFacade.getCartByid(idUser);
       logger.info("currentCart: " + currentCart);
        int idCart = currentCart.getIdCart();
      logger.info("idCart: " + idCart + " idSku: " + idSku);
       cartFacade.addToCart(idSku, idCart);

        return "redirect:/index/";
    }



}