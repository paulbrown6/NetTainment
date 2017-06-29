package com.dao.implement;

import com.dao.ProfileDAO;
import com.entity.Profile;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Repository("profileDAOImplement")
@Transactional
public class ProfileDAOImplement implements ProfileDAO {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public Profile createProfile(Profile profile) {
        sessionFactory.getCurrentSession().save(profile);
        return profile;
    }

    @Override
    public void updateProfile(Profile profile) {
        sessionFactory.getCurrentSession().update(profile);

    }

    @Override
    public void deleteProfile(Profile profile) {
        Profile mergProfile = (Profile) sessionFactory.getCurrentSession().merge(profile);
        sessionFactory.getCurrentSession().delete(mergProfile);
    }

    @Override
    public Profile getProfileById(Long id) {
        Profile profile = sessionFactory.getCurrentSession().get(Profile.class, id);
        return profile;
    }
}
