package com.sopra.service;

import com.sopra.model.AddressBook;
import com.sopra.model.User;

public interface UserService {
    User login(String email, String password);
    int insertAddress(AddressBook addressBook);
    int insertUser(User user);
    int getIdAddressByIdUser(int idUser);
}
