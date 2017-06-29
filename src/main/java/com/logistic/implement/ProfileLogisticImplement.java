package com.logistic.implement;

import com.dao.ProfileDAO;
import com.entity.Profile;
import com.logistic.ProfileLogistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Service("profileService")
public class ProfileLogisticImplement implements ProfileLogistic {

    @Autowired
    ProfileDAO profileDAO;

    @Override
    @Transactional
    public void createProfile(Profile profile) {
        profileDAO.createProfile(profile);
    }

    @Override
    @Transactional
    public void updateProfile(Profile profile) {
        profileDAO.updateProfile(profile);
    }

    @Override
    @Transactional
    public void deleteProfile(Profile profile) {
        profileDAO.deleteProfile(profile);
    }

    @Override
    @Transactional
    public Profile getProfileById(Long id) {
        return profileDAO.getProfileById(id);
    }

}
