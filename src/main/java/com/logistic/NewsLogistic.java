package com.logistic;

import com.entity.News;

import java.util.List;

/**
 * Created by Paul Brown on 07.02.2017.
 */
public interface NewsLogistic {

    void createNews(News news);

    void updateNews(News news);

    void deleteNews(News news);

    News getNewsById(Long id);

    List<News> getAllNews();
}
