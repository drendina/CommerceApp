package com.sopra.dao;

import com.sopra.model.AddressBook;
import com.sopra.model.User;

public interface UserDAO {
    User login(String email, String password);
    int insertAddress(AddressBook addressBook);
    int insertUser(User user);
}
