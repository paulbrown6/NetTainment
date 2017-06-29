package com.logistic.implement;

import com.dao.AudioDAO;
import com.entity.Audio;
import com.logistic.AudioLogistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Service("audioService")
public class AudioLogisticImplement implements AudioLogistic {

    @Autowired
    AudioDAO audioDAO;

    @Override
    @Transactional
    public void createAudio(Audio audio) {
        audioDAO.createAudio(audio);
    }

    @Override
    @Transactional
    public void updateAudio(Audio audio) {
        audioDAO.updateAudio(audio);
    }

    @Override
    @Transactional
    public void deleteAudio(Audio audio) {
        audioDAO.deleteAudio(audio);
    }

    @Override
    @Transactional
    public Audio getAudioById(Long id) {
        return audioDAO.getAudioById(id);
    }

    @Override
    @Transactional
    public List<Audio> getAllAudio() {
        return audioDAO.getAllAudio();
    }
}
