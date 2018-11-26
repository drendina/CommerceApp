package com.sopra.controller;

import com.sopra.data.CartData;
import com.sopra.data.CartPageData;
import com.sopra.data.UserData;
import com.sopra.facade.CartFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView deployCartpage(HttpServletRequest request,
                                       @ModelAttribute("user") UserData userData) {
        logger.info("Deploying Cartpage");
        logger.info(request.getSession().getAttribute("loggedUser"));
        int idUser = ((UserData) request.getSession().getAttribute("loggedUser")).getIdUser();
        CartData currentCart = cartFacade.getCartByid(idUser);
/*
        List itemList = cartFacade.getProductList(idUser);
*/
        List<CartPageData> itemList= cartFacade.getCart(idUser);
        int totalPrice = cartFacade.getTotal(itemList);

        return new ModelAndView("cartPage")
                .addObject("totalPrice", totalPrice)
                .addObject("itemList", itemList)
                .addObject("currentCart", currentCart);
    }


    @RequestMapping(value = "/addToCart", method = RequestMethod.GET)
    public void addToCart(HttpSession session, @RequestParam int idSku) {
        logger.info("Add to cart  - idSku: " + idSku);


        /*UserData UserDataTEMP = (UserData)session.getAttribute("loggedUser");
        logger.info(UserDataTEMP);
        int idUser = UserDataTEMP.getIdUser();
       logger.info("idUser: " + idUser);*/

       int idUser = ((UserData) session.getAttribute("loggedUser")).getIdUser();
        logger.info("idUser: " + idUser);

        CartData currentCart = cartFacade.getCartByid(idUser);
       logger.info("currentCart: " + currentCart);
        int idCart = currentCart.getIdCart();
      logger.info("idCart: " + idCart + " idSku: " + idSku);
       cartFacade.addToCart(idSku, idCart);
    }

    @RequestMapping(value = "/removeItem")
    public String removeItemsFromCart(@RequestParam int idSku, @RequestParam int idCart){
        cartFacade.removeFromCart(idSku, idCart);
        return "redirect:/cart/";

    }

    @RequestMapping(value = "/addToCartSmart", method = RequestMethod.GET)
    public String addItemToCart(@RequestParam int idSku, @RequestParam int idCart){
        cartFacade.addToCart(idSku, idCart);
        return "redirect:/cart/";
    }

    @RequestMapping(value = "/showCart")
    public List<CartPageData> retreiveItemsInCart(@RequestParam int idUser){
        return cartFacade.getCart(idUser);
    }

}