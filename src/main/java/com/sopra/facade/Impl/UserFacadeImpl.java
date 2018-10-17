package com.sopra.facade.Impl;

import com.sopra.data.UserData;
import com.sopra.facade.UserFacade;
import com.sopra.form.CompleteUserForm;
import com.sopra.model.AddressBook;
import com.sopra.model.User;
import com.sopra.service.CartService;
import com.sopra.service.UserService;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;

@Repository
@Transactional
public class UserFacadeImpl implements UserFacade {

    private final static Logger logger = Logger.getLogger(UserFacade.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Override
    public UserData login(String emailLogin, String passwordLogin) throws NoSuchAlgorithmException{

        User temp = userService.login(emailLogin,passwordLogin);
        logger.info(temp);
       /* if( temp == null){
            return null;
        }
        else //temp != null
            {
            logger.info(temp.getIdUser() +" " +temp.getTitle()+""+ temp.getName()+""+ temp.getSurname()+""+ temp.getRole());

            return  new UserData(temp.getIdUser(), temp.getTitle(), temp.getName(), temp.getSurname(), temp.getRole());
        }*/
        // - - - - - -
        if (temp != null){
            return new UserData(temp.getIdUser(), temp.getTitle(), temp.getName(), temp.getSurname(), temp.getRole());
        }else
        {return null;}
    }

    @Override
    public void manageInsert(CompleteUserForm cuf) throws NoSuchAlgorithmException {
        logger.info("Object: "+ cuf);
        AddressBook tempAddressBook = new AddressBook(cuf.getAddress(), cuf.getNumber(), cuf.getCap(), cuf.getCity(), cuf.getNation());
        logger.info(tempAddressBook);
        int idAddressBook = userService.insertAddress(tempAddressBook);
        String passwordCripted = userService.cripter(cuf.getPassword());
        User tempUser = new User(cuf.getTitle(),cuf.getName(),cuf.getSurname(), idAddressBook, cuf.getEmail(), passwordCripted ,"USER", cuf.getNewsletter());
        logger.info(tempUser);
        int idUser = userService.insertUser(tempUser);
        cartService.createCartBindWithUser(idUser);
    }

    @Override
    public int getIdAddressByIdUser(int idUser) {
        return userService.getIdAddressByIdUser(idUser);
    }
}
