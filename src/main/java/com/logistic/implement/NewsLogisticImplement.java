package com.logistic.implement;

import com.dao.NewsDAO;
import com.entity.News;
import com.logistic.NewsLogistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Service("newsService")
public class NewsLogisticImplement implements NewsLogistic {

    @Autowired
    NewsDAO newsDAO;

    @Override
    @Transactional
    public void createNews(News news) {
        newsDAO.createNews(news);
    }

    @Override
    @Transactional
    public void updateNews(News news) {
        newsDAO.updateNews(news);
    }

    @Override
    @Transactional
    public void deleteNews(News news) {
        newsDAO.deleteNews(news);
    }

    @Override
    @Transactional
    public News getNewsById(Long id) {
        return newsDAO.getNewsById(id);
    }

    @Override
    @Transactional
    public List<News> getAllNews() {
        return newsDAO.getAllNews();
    }
}
