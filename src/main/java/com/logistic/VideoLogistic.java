package com.logistic;

import com.entity.Video;

import java.util.List;

/**
 * Created by Paul Brown on 07.02.2017.
 */
public interface VideoLogistic {

    void createVideo(Video video);

    void updateVideo(Video video);

    void deleteVideo(Video video);

    Video getVideoById(Long id);

    List<Video> getAllVideo();
}
