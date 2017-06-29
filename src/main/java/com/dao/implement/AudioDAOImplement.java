package com.dao.implement;

import com.dao.AudioDAO;
import com.entity.Audio;
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

@Repository("audioDAOImplement")
@Transactional
public class AudioDAOImplement implements AudioDAO {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public Audio createAudio(Audio audio) {
        sessionFactory.getCurrentSession().save(audio);
        return audio;
    }

    @Override
    public void updateAudio(Audio audio) {
        sessionFactory.getCurrentSession().update(audio);
    }

    @Override
    public void deleteAudio(Audio audio) {
        Audio mergAudio = (Audio) sessionFactory.getCurrentSession().merge(audio);
        sessionFactory.getCurrentSession().delete(mergAudio);
    }

    @Override
    public Audio getAudioById(Long id) {
        Audio audio = sessionFactory.getCurrentSession().get(Audio.class, id);
        return audio;
    }

    @Override
    public List<Audio> getAllAudio() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Audio.class);
        criteria.addOrder(Order.desc("name"));
        List result = criteria.list();
        return result;
    }

}
