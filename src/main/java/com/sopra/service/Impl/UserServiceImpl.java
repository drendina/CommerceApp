package com.sopra.service.Impl;

import com.sopra.dao.UserDAO;
import com.sopra.model.AddressBook;
import com.sopra.model.User;
import com.sopra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(String email, String password) {
        return userDAO.login(email, password);
    }

    @Override
    public int insertAddress(AddressBook addressBook) {
        return userDAO.insertAddress(addressBook);
    }

    @Override
    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }
}
