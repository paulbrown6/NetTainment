package com.dao.implement;

import com.dao.VideoDAO;
import com.entity.Video;
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

@Repository("videoDAOImplement")
@Transactional
public class VideoDAOImplement implements VideoDAO {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public Video createVideo(Video video) {
        sessionFactory.getCurrentSession().save(video);
        return video;
    }

    @Override
    public void updateVideo(Video video) {
        sessionFactory.getCurrentSession().update(video);
    }

    @Override
    public void deleteVideo(Video video) {
        Video mergVideo = (Video) sessionFactory.getCurrentSession().merge(video);
        sessionFactory.getCurrentSession().delete(mergVideo);
    }

    @Override
    public Video getVideoById(Long id) {
        Video video = sessionFactory.getCurrentSession().get(Video.class, id);
        return video;
    }

    @Override
    public List<Video> getAllVideo() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Video.class);
        criteria.addOrder(Order.desc("videoDate"));
        List result = criteria.list();
        return result;
    }
}
