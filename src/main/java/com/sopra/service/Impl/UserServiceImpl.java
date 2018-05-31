package com.sopra.service.Impl;

import com.sopra.dao.UserDAO;
import com.sopra.model.AddressBook;
import com.sopra.model.User;
import com.sopra.service.UserService;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;

import javax.transaction.Transactional;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Repository
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(String email, String password, BindingResult bindingResult) throws NoSuchAlgorithmException {
        return userDAO.login(email, cripter(password), bindingResult);
    }

    @NotNull
    @Override
    public String cripter(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < byteData.length; i++)
        { sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1)); }
        logger.info(sb.toString());
        return sb.toString();
    }

    @Override
    public int insertAddress(AddressBook addressBook) {
        return userDAO.insertAddress(addressBook);
    }

    @Override
    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }

    @Override
    public int getIdAddressByIdUser(int idUser) {
        return userDAO.getIdAddressByIdUser(idUser);
    }
}
