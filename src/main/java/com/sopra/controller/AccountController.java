package com.sopra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping(value = "/myAccount")
public class AccountController {

    @RequestMapping(value = {"/", ""})
    public ModelAndView deployHomepage() {
        ModelAndView mv = new ModelAndView("myAccountPage");
        return mv;
    }
}
