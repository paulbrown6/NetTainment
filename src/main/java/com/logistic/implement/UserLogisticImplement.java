package com.logistic.implement;

import com.dao.UserDAO;
import com.entity.User;
import com.logistic.UserLogistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Service("userLogistic")
public class UserLogisticImplement implements UserLogistic {

    @Autowired
    UserDAO userDAO;


    @Override
    @Transactional
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    @Transactional
    public User getUserByLogin(String login) {
        return userDAO.getUserByLogin(login);
    }

    @Override
    @Transactional
    public boolean isLoginThereIs(String login) {
        return userDAO.isLoginThereIs(login);
    }

    @Override
    @Transactional
    public boolean isPasswordCorrect(User user) {
        return userDAO.isPasswordCorrect(user);
    }
}
