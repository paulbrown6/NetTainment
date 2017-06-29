package com.dao;

import com.entity.Video;

import java.util.List;

/**
 * Created by Paul Brown on 07.02.2017.
 */
public interface VideoDAO {

    Video createVideo(Video video);

    void updateVideo(Video video);

    void deleteVideo(Video video);

    Video getVideoById(Long id);

    List<Video> getAllVideo();
}
