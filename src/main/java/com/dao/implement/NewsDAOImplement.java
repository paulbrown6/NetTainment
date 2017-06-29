package com.dao.implement;

import com.dao.NewsDAO;
import com.entity.News;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Repository("newsDAOImplement")
@Transactional
public class NewsDAOImplement implements NewsDAO {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public News createNews(News news) {
        sessionFactory.getCurrentSession().save(news);
        return news;
    }

    @Override
    public void updateNews(News news) {
        sessionFactory.getCurrentSession().update(news);
    }

    @Override
    public void deleteNews(News news) {
        News mergNews = (News) sessionFactory.getCurrentSession().merge(news);
        sessionFactory.getCurrentSession().delete(mergNews);
    }

    @Override
    public News getNewsById(Long id) {
        News news = sessionFactory.getCurrentSession().get(News.class, id);
        return news;
    }

    @Override
    public List<News> getAllNews() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(News.class);
        criteria.addOrder(Order.desc("newsID"));
        List result = criteria.list();
        return result;
    }
}
