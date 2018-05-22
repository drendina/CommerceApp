package com.sopra.controller;

import com.sopra.data.UserData;
import com.sopra.facade.UserFacade;
import com.sopra.form.CompleteUserForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping(value = "/form")
public class FormController {
    private static final Logger logger = Logger.getLogger(FormController.class);

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/submit")
    public ModelAndView submitForm(@ModelAttribute("completeUserForm")CompleteUserForm cuf, @ModelAttribute("user") UserData userData){
        logger.info("Submitting form");
        userFacade.manageInsert(cuf);
        return new ModelAndView("index");
    }
}
