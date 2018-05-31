package com.sopra.dao.Impl;

import com.sopra.dao.UserDAO;
import com.sopra.model.AddressBook;
import com.sopra.model.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAO.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User login(String email, String password, BindingResult bindingResult)  {
        try{
        logger.info("Login: " + email + " - " + password );

        User user = (User) (sessionFactory.getCurrentSession()
                .createQuery("FROM User U WHERE U.email = :email AND U.password = :password")
                .setParameter("email", email)
                .setParameter("password", password)
                .list()).get(0);
        logger.info(user);
        return user;
        }
        catch (Exception e ){
            logger.info("login failed");
            ObjectError error = new ObjectError("Login error", "Login error");
            bindingResult.addError(error);
            return new User();
        }
    }

    @Override
    public int insertAddress(AddressBook addressBook) {
       return (int)sessionFactory.getCurrentSession().save(addressBook);
    }

    @Override
    public int insertUser(User user) {
        logger.info(user);
        return (int)sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public int getIdAddressByIdUser(int idUser) {
        User temp = (User) sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE idUser = :idUser")
                .setParameter("idUser", idUser)
                .list()
                .get(0);
        return temp.getIdAddress();
    }
}
