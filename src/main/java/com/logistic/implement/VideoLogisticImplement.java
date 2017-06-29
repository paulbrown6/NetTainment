package com.logistic.implement;

import com.dao.VideoDAO;
import com.entity.Video;
import com.logistic.VideoLogistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Service("videoService")
public class VideoLogisticImplement implements VideoLogistic {

    @Autowired
    VideoDAO videoDAO;

    @Override
    @Transactional
    public void createVideo(Video video) {
        videoDAO.createVideo(video);
    }

    @Override
    @Transactional
    public void updateVideo(Video video) {
        videoDAO.updateVideo(video);
    }

    @Override
    @Transactional
    public void deleteVideo(Video video) {
        videoDAO.deleteVideo(video);
    }

    @Override
    @Transactional
    public Video getVideoById(Long id) {
        return videoDAO.getVideoById(id);
    }

    @Override
    @Transactional
    public List<Video> getAllVideo() {
        return videoDAO.getAllVideo();
    }
}
