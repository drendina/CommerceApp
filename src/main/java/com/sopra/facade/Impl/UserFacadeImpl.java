package com.sopra.facade.Impl;

import com.sopra.data.UserData;
import com.sopra.facade.UserFacade;
import com.sopra.form.CompleteUserForm;
import com.sopra.model.AddressBook;
import com.sopra.model.User;
import com.sopra.service.CartService;
import com.sopra.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserFacadeImpl implements UserFacade {

    private final static Logger logger = Logger.getLogger(UserFacade.class);
    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Override
    public UserData login(String email, String password) {
        User temp = userService.login(email,password);
        return  new UserData(temp.getIdUser(), temp.getTitle(), temp.getName(), temp.getSurname(), temp.getRole());
    }

    @Override
    public void manageInsert(CompleteUserForm cuf) {
        logger.info("Object: "+ cuf);
        AddressBook tempAddressBook = new AddressBook(cuf.getAddress(), cuf.getNumber(), cuf.getCap(), cuf.getCity(), cuf.getNation());
        logger.info(tempAddressBook);
        int idAddressBook = userService.insertAddress(tempAddressBook);
        User tempUser = new User(cuf.getTitle(),cuf.getName(),cuf.getSurname(), idAddressBook, cuf.getEmail(), cuf.getPassword(),"USER", cuf.getNewsletter());
        logger.info(tempUser);
        int idUser = userService.insertUser(tempUser);
        cartService.createCartBindWithUser(idUser);
    }
}
