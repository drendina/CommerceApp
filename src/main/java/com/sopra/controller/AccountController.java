package com.sopra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping(value = "/myAccount")
public class AccountController {

    @RequestMapping(value = {"/", ""})
    public ModelAndView deployAccountControllerPage(HttpServletRequest request) {
        return new ModelAndView("myAccountPage")
                .addObject("loggedUser", request.getSession().getAttribute("loggedUser"));
    }
}
