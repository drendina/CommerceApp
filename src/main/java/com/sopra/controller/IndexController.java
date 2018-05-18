package com.sopra.controller;

import com.sopra.facade.IndexFacade;
import com.sopra.form.CompleteUserForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
@RequestMapping(value = "/index")
public class IndexController {

    private static final Logger logger = Logger.getLogger(IndexController.class);
    @Autowired
    private IndexFacade indexFacade;

    @RequestMapping(value = {"/", ""})
    public ModelAndView deployHomepage(){
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

    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    public ModelAndView redirectToFormPage(@ModelAttribute("completeUserForm") CompleteUserForm completeUserForm){
        logger.info("Deploying form page");
        return new ModelAndView("formPage");
    }


}
