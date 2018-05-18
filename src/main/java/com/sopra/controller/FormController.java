package com.sopra.controller;

import com.sopra.form.CompleteUserForm;
import com.sopra.model.AddressBook;
import com.sopra.model.User;
import org.apache.log4j.Logger;
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

    @RequestMapping(method = RequestMethod.POST, value = "/submit")
    public ModelAndView submitForm(@ModelAttribute("completeUserForm")CompleteUserForm cuf){
        logger.info("Submitting form");
        logger.info("Object: "+ cuf);
        AddressBook tempAddressBook = new AddressBook(cuf.getAddress(), cuf.getNumber(), cuf.getCap(), cuf.getCity(), cuf.getNation());
        logger.info(tempAddressBook);
        //TODO RECUPERARE ID DELL'INDIRIZZO APPENA INSERITO E METTERLO IN idNewAddress
        int idNewAddress = 0;
        User tempUser = new User(cuf.getTitle(),cuf.getName(),cuf.getSurname(), idNewAddress, cuf.getEmail(), cuf.getPassword(),"USER", cuf.getNewsletter());
        logger.info(tempUser);
        return new ModelAndView("index");
    }
}
