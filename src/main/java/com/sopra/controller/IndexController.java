package com.sopra.controller;

import com.sopra.data.CartData;
import com.sopra.data.UserData;
import com.sopra.facade.CartFacade;
import com.sopra.facade.IndexFacade;
import com.sopra.facade.UserFacade;
import com.sopra.form.CompleteUserForm;
import com.sopra.form.LoginForm;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@Transactional
@RequestMapping(value = "/index")
public class IndexController {

    private static final Logger logger = Logger.getLogger(IndexController.class);
    @Autowired
    private IndexFacade indexFacade;

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private CartFacade cartFacade;


    @RequestMapping(value = {"/", ""})
    public ModelAndView deployHomepage(@ModelAttribute("login") LoginForm loginForm){
        logger.info("Deploying Homepage");
        return new ModelAndView("index");
    }
    @RequestMapping(value = "/getAllProduct")
    public @ResponseBody List getAllProduct(){
        logger.info("Getting product list from database");
        return indexFacade.getAllProduct();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/changeLanguageEnglish" )
    public String changeLanguageEnglish( HttpServletResponse response){
        logger.info("Change language: English");
        Cookie cookie = new Cookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE", "en");
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/index/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/changeLanguageItalian")
    public String changeLanguageItalian(HttpServletResponse response){
        logger.info("Change language: Italian");
        Cookie cookie = new Cookie( "org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE", "it");
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/index/";
    }


    @RequestMapping(value = "/login")
    public String login (HttpServletRequest request, HttpServletResponse response, Model model, @Valid @ModelAttribute LoginForm loginForm, BindingResult bindingResult) throws NoSuchAlgorithmException, ServletException, IOException {
        logger.info("Login user. Info: " + loginForm.getEmail() + " "+ loginForm.getPassword());
        UserData loggedUser = userFacade.login(loginForm.getEmail(),loginForm.getPassword(),bindingResult);

        if (bindingResult.hasErrors()){
           //TODO GESTIRE L'ERRORE INSERITO NEL BINDING RESULT
        }
        else{
            request.getSession().setAttribute("loggedUser", loggedUser);

            CartData tempCartData = cartFacade.getCartByid(loggedUser.getIdUser());
            request.getSession().setAttribute("cart", tempCartData);

            int cartQty = cartFacade.getCartQty(tempCartData.getIdCart());
            request.getSession().setAttribute("quantity", cartQty);
        }

        return "redirect:/index";
    }

    @RequestMapping(value = "/quantity")
    public String getQuantity (HttpServletRequest request){
//        UserData loggedUser = (UserData) request.getSession().getAttribute("loggedUser");
//        CartData tempCartData = cartFacade.getCartByid(loggedUser.getIdUser());
//        return cartFacade.getCartQty(tempCartData.getIdCart());
        logger.info(request.getSession().getAttribute("quantity"));
       //return (int) request.getSession().getAttribute("quantity");
            return "Ciao papà";
    }

    @RequestMapping(value = "/ajax/quantity")
    public @ResponseBody String getQuantityAjax (HttpServletRequest request){
//        UserData loggedUser = (UserData) request.getSession().getAttribute("loggedUser");
//        CartData tempCartData = cartFacade.getCartByid(loggedUser.getIdUser());
//        return cartFacade.getCartQty(tempCartData.getIdCart());
        logger.info(request.getSession().getAttribute("quantity").toString() + " value of cart");

        //return request.getSession().getAttribute("quantity").toString();
        return "Ciao mamma";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/index/";
    }

}
