package com.controllers;

import com.entity.News;
import com.entity.User;
import com.logistic.NewsLogistic;
import com.logistic.UserLogistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Paul Brown on 19.01.2017.
 */

@Controller
public class ControllerUsers {

    @Autowired
    UserLogistic userLog;

    @Autowired
    NewsLogistic newsLog;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView main(HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        HttpSession session = req.getSession(true);
        User userIn = new User();
        userIn.setLogin(login);
        userIn.setPassword(pass);

        if(userLog.isLoginThereIs(login) && userLog.isPasswordCorrect(userIn)) {
            session.setAttribute("user", login);
            modelAndView.setViewName("news");
            List<News> news = newsLog.getAllNews();
            modelAndView.addObject("newsAttr", news);
            return modelAndView;
        }
        else {
            modelAndView.addObject("error", "Вы не правильно ввели логин или пароль!");
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }
}
