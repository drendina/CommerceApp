package com.sopra.controller;

import com.sopra.data.ProductData;
import com.sopra.data.UserData;
import com.sopra.facade.ProductFacade;
import com.sopra.facade.UserFacade;
import com.sopra.form.CompleteUserForm;
import com.sopra.form.LoginForm;
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
import java.security.NoSuchAlgorithmException;

@Controller
@Transactional
@RequestMapping(value = "/management")
public class ManagementController {

    private static final Logger logger = Logger.getLogger(ManagementController.class);

    @Autowired
    private ProductFacade productFacade;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = {"/", ""})
    public ModelAndView deployManagementPage(@ModelAttribute("productData") ProductData productData,
                                             @ModelAttribute ("login") LoginForm loginForm,
                                             @ModelAttribute("completeUserForm") CompleteUserForm completeUserForm){
        logger.info("Deploying Management Page");
        return new ModelAndView("managementPage");
    }

    @RequestMapping( value = "/insert", method = RequestMethod.POST)
    public String insertProduct (@ModelAttribute("productData") ProductData productData) {
        logger.info(productData);
        productFacade.insertProduct(productData);
        return "redirect:/management";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/submit")
    public ModelAndView submitForm(@ModelAttribute("userData") UserData userData,
                                   @Valid @ModelAttribute("completeUserForm")CompleteUserForm completeUserForm,
                                   BindingResult bindingResult) throws NoSuchAlgorithmException {
        boolean x = completeUserForm.getPassword().equals(completeUserForm.getPasswordRepeat());

        if(bindingResult.hasErrors() || !x){
            logger.info("Error");
            return new ModelAndView("formPage","completeUserForm",completeUserForm).addObject("login", new LoginForm());
        }
        else {
            logger.info("Submitting form");
            userFacade.manageInsert(completeUserForm, true);

            return new ModelAndView("index", "user", userData).addObject("login", new LoginForm());
        }
    }
}