package com.sopra.controller;

import com.sopra.beans.SessionBeans;
import com.sopra.data.CartData;
import com.sopra.data.UserData;
import com.sopra.facade.CartFacade;
import com.sopra.facade.ProductFacade;
import com.sopra.facade.UserFacade;
import com.sopra.form.CompleteUserForm;
import com.sopra.form.LoginForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Transactional
@RequestMapping(value = "/index")
public class IndexController {

    private static final Logger logger = Logger.getLogger(IndexController.class);
    @Autowired
    private ProductFacade productFacade;

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private CartFacade cartFacade;


    @RequestMapping(value = {"/", ""})
    public ModelAndView deployHomepage(@ModelAttribute ("login") LoginForm loginForm){
        logger.info("Deploying Homepage");
        return new ModelAndView("index").addObject("pageName", "index");
    }
    @RequestMapping(value = "/getAllProduct", method = RequestMethod.GET)
    public @ResponseBody List getAllProduct(){
        logger.info("Getting product list from database");
        List list = productFacade.getAllProduct();
        logger.info("I.C. list is: "+ list);
        return list;
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

/*    @RequestMapping(value = "/quantity")
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
    }*/

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/index/";
    }


    @Resource(name = "sessionBeans")
    private SessionBeans sessionBeans;

    @RequestMapping(value = "/error", method = GET)
    public boolean formErrors (@Valid @ModelAttribute ("login") LoginForm loginForm, BindingResult bindingResult) throws NoSuchAlgorithmException{
        UserData loggedUser = userFacade.login(loginForm.getEmailLogin(),loginForm.getPasswordLogin());
            if(loggedUser == null) {
                ObjectError error = new ObjectError("loggedUser", "errore");
                bindingResult.addError(error);
                return true;
            }
        return false;
        }


    @RequestMapping(value = "/login", method = POST)
    public ModelAndView login (HttpServletRequest request,
                               Model model,
                               @Valid @ModelAttribute ("login") LoginForm loginForm,
                               BindingResult bindingResult) throws NoSuchAlgorithmException {

        logger.info("Login user Info: " + loginForm.getEmailLogin() + " "+ loginForm.getPasswordLogin());
        ModelAndView mv = new ModelAndView("index");
        CompleteUserForm completeUserFormPlain = new CompleteUserForm();

        if (bindingResult.hasErrors()){
            logger.info("Errore in validazione form. Accesso negato! " +loginForm.getPasswordLogin());
            //TODO GESTIRE L'ERRORE INSERITO NEL BINDING RESULT (IndexOutOfBoundsException)
            mv.setViewName("index");
            mv.addObject("login", loginForm);
            mv.addObject("completeUserForm", completeUserFormPlain);

        }
        else{
            logger.info("Tutti i campi sono stati fillati, verifico l'esistenza dell'utente nel sistema... " + loginForm.getEmailLogin());
            UserData loggedUser = userFacade.login(loginForm.getEmailLogin(),loginForm.getPasswordLogin());
            if(loggedUser == null){
                logger.info("Utente non verificato. Accesso negato!");
                ObjectError error = new ObjectError("loggedUser", "errore");
                bindingResult.addError(error);
                mv.setViewName("index");
                mv.addObject("login", loginForm);
                mv.addObject("completeUserForm", completeUserFormPlain);
            }else{
                logger.info("Utente verificato! Benvenuto " +loggedUser);

                mv.setViewName("index");
                request.getSession().setAttribute("loggedUser", loggedUser);

                /*sessionBeans.setName(loggedUser.getName());*/
                model.addAttribute("sessionUserName", sessionBeans.getName());

                CartData tempCartData = cartFacade.getCartByid(loggedUser.getIdUser());
                request.getSession().setAttribute("cart", tempCartData);
                int cartQty = cartFacade.getCartQty(tempCartData.getIdCart());
                request.getSession().setAttribute("quantity", cartQty);

            }


        }
       return mv;
    }
}
