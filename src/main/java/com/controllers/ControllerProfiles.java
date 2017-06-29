package com.controllers;

import com.entity.Profile;
import com.entity.User;
import com.logistic.ProfileLogistic;
import com.logistic.UserLogistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Paul Brown on 29.06.2017.
 */
@Controller
public class ControllerProfiles {

    @Autowired
    UserLogistic userLog;
    @Autowired
    ProfileLogistic profileLog;

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView main(HttpServletRequest req, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("firstName");
        String dateS = req.getParameter("date");
        String sex = req.getParameter("sex");
        String login = req.getParameter("login");
        String pass = req.getParameter("password");

        if (pass.toCharArray().length > 7){
                if (!userLog.isLoginThereIs(login)){
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        Date date= format.parse(dateS);
                        User newUser = new User();
                        newUser.setFirstname(firstName);
                        newUser.setLastname(lastName);
                        newUser.setLogin(login);
                        newUser.setEmail(login);
                        newUser.setPassword(pass);
                        Profile newProfile = new Profile();
                        newProfile.setFirstName(firstName);
                        newProfile.setLastName(lastName);
                        newProfile.setEmail(login);
                        newProfile.setBirthDate(date);
                        newProfile.setSex(sex);
                        newUser.setProfile(newProfile);
                        newProfile.setUser(newUser);
                        userLog.createUser(newUser);
                    }
                    catch (Exception e){
                        System.err.println(e);
                    }
                    modelAndView.setViewName("login");
                    return modelAndView;
                }
                else {
                    modelAndView.addObject("error", "Пользователь с таким email уже зарегистрирован!");
                    modelAndView.setViewName("logout");
                    return modelAndView;
                }
        }
        else {
                modelAndView.addObject("error", "Пароль должен содержать не менее 8 символов!");
                modelAndView.setViewName("logout");
                return modelAndView;
        }
    }
}
