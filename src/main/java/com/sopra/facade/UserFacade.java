package com.sopra.facade;

import com.sopra.data.UserData;
import com.sopra.form.CompleteUserForm;
import com.sopra.model.AddressBook;
import com.sopra.model.User;
import org.springframework.validation.BindingResult;

import java.security.NoSuchAlgorithmException;

public interface UserFacade {
    UserData login(String email, String password, BindingResult bindingResult) throws NoSuchAlgorithmException;

    void manageInsert(CompleteUserForm cuf) throws NoSuchAlgorithmException;

    int getIdAddressByIdUser (int idUser);

//    int insertAddress(AddressBook addressBook);
//
//    void insertUser(User user);
}
