package com.controllers;

import com.entity.News;
import com.logistic.NewsLogistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Paul Brown on 29.06.2017.
 */

@Controller
public class ControllerNews {

    @Autowired
    NewsLogistic newsLog;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public ModelAndView main(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        List<News> news = newsLog.getAllNews();
        session.setAttribute("newsAttr", news);
        modelAndView.setViewName("news");
        return modelAndView;
    }
}
