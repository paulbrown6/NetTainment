package com.dao;

import com.entity.User;

/**
 * Created by Paul Brown on 07.02.2017.
 */
public interface UserDAO {

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User getUserByLogin(String login);

    boolean isLoginThereIs(String login);

    boolean isPasswordCorrect(User user);
}
