package com.sopra.controller;

import com.sopra.data.UserData;
import com.sopra.facade.UserFacade;
import com.sopra.form.CompleteUserForm;
import com.sopra.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@Transactional
@RequestMapping(value = "/form")
public class FormController {
    private static final Logger logger = Logger.getLogger(FormController.class);

    @Autowired
    private UserFacade userFacade;



    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    public ModelAndView deployFormPage(@ModelAttribute("completeUserForm") CompleteUserForm completeUserForm){
        logger.info("Deploying form page");
        return new ModelAndView("formPage");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/submit")
    public ModelAndView submitForm(@ModelAttribute("userData") UserData userData,
                                   @Valid @ModelAttribute("completeUserForm")CompleteUserForm completeUserForm,
                                   BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            logger.info("Error");
            return new ModelAndView("formPage","completeUserForm",completeUserForm);
        }
        else {
            logger.info("Submitting form");
            userFacade.manageInsert(completeUserForm);

            return new ModelAndView("index", "user", userData);
        }
    }


}
