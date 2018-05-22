package com.sopra.facade;

import com.sopra.data.UserData;
import com.sopra.form.CompleteUserForm;
import com.sopra.model.AddressBook;
import com.sopra.model.User;

public interface UserFacade {
    UserData login(String email, String password);

    void manageInsert(CompleteUserForm cuf);

//    int insertAddress(AddressBook addressBook);
//
//    void insertUser(User user);
}
