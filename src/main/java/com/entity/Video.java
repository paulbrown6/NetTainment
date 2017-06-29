package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Entity
@Table(name = "video")
public class Video implements Serializable {

    @Id
    @Column(name = "video_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoID;

    @Column(name = "video_date")
    private Date videoDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userID;

    @Column(name = "name", length = 256)
    private String name;

    @Column(name = "link")
    private String link;

    public Long getVideoID() {
        return videoID;
    }

    public void setVideoID(Long videoID) {
        this.videoID = videoID;
    }

    public Date getVideoDate() {
        return videoDate;
    }

    public void setVideoDate(Date videoDate) {
        this.videoDate = videoDate;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
