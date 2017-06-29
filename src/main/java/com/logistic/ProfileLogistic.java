package com.logistic;

import com.entity.Profile;

/**
 * Created by Paul Brown on 07.02.2017.
 */
public interface ProfileLogistic {

    void createProfile(Profile profile);

    void updateProfile(Profile profile);

    void deleteProfile(Profile profile);

    Profile getProfileById(Long id);

}
