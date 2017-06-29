package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Entity
@Table(name = "news")
public class News implements Serializable {

    @Id
    @Column(name = "news_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsID;

    @Column(name = "news_date")
    private Date newsDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userID;

    @Column(name = "name", length = 256)
    private String name;

    @Column(name = "text")
    private String text;

    @Column(name = "picture")
    private byte[] picture;

    public Long getNewsID() {
        return newsID;
    }

    public void setNewsID(Long newsID) {
        this.newsID = newsID;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
