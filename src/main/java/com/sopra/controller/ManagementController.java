package com.sopra.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping(value = "/management")
public class ManagementController {

    private static final Logger logger = Logger.getLogger(ManagementController.class);

    @RequestMapping(value = {"/", ""})
    public ModelAndView deployHomepage(){
        logger.info("Deploying Management Page");
        return new ModelAndView("managementPage");
    }
}