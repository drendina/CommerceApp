package com.sopra.service;

import com.sopra.model.AddressBook;
import com.sopra.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.BindingResult;

import java.security.NoSuchAlgorithmException;

public interface UserService {
    User login(String email, String password) throws NoSuchAlgorithmException;

    @NotNull String cripter(String password) throws NoSuchAlgorithmException;

    int insertAddress(AddressBook addressBook);
    int insertUser(User user);
    int getIdAddressByIdUser(int idUser);
}
