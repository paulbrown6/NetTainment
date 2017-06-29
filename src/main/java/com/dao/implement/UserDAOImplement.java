package com.dao.implement;

import com.dao.UserDAO;
import com.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Repository("userDAOImplement")
@Transactional
public class UserDAOImplement implements UserDAO {


    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public User createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public void updateUser(User user) {
        User mergUser = (User) sessionFactory.getCurrentSession().merge(user);
        sessionFactory.getCurrentSession().update(mergUser);
    }

    @Override
    public void deleteUser(User user) {
        User mergUser = (User) sessionFactory.getCurrentSession().merge(user);
        sessionFactory.getCurrentSession().delete(mergUser);
    }

    @Override
    public User getUserByLogin(String login) {
        String userHQL = "FROM User WHERE login = :login";
        Query query = sessionFactory.getCurrentSession().createQuery(userHQL);
        query.setParameter("login", login);
        return (User) query.uniqueResult();
    }

    @Override
    public boolean isLoginThereIs(String login) {
        String userHQL = "FROM User WHERE login = :login";
        Query query = sessionFactory.getCurrentSession().createQuery(userHQL);
        query.setParameter("login", login);
        System.out.println(login + " this String");
        System.out.println(query.getParameter("login") + " this Query");
        return query.list().size() > 0;
    }

    @Override
    public boolean isPasswordCorrect(User user) {
        String login = user.getLogin();
        String password = user.getPassword();

        String userHQL = "FROM User WHERE password=:password AND login=:login";
        Query query = sessionFactory.getCurrentSession().createQuery(userHQL);
        query.setParameter("password", password);
        query.setParameter("login", login);
        System.out.println(password + " this String");
        System.out.println(query.getParameter("password") + " this Query");
        List users = query.list();

        return users.size() > 0;
    }
}
