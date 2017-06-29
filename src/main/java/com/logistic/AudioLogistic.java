package com.logistic;

import com.entity.Audio;

import java.util.List;

/**
 * Created by Paul Brown on 07.02.2017.
 */
public interface AudioLogistic {

    void createAudio(Audio audio);

    void updateAudio(Audio audio);

    void deleteAudio(Audio audio);

    Audio getAudioById(Long id);

    List<Audio> getAllAudio();
}
