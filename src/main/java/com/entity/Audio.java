package com.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Entity
@Table(name = "audio")
public class Audio implements Serializable {

    @Id
    @Column(name = "audio_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long audioID;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userID;

    @Column(name = "name", length = 256)
    private String name;

    @Column(name = "link")
    private String link;

    public Long getAudioID() {
        return audioID;
    }

    public void setAudioID(Long audioID) {
        this.audioID = audioID;
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
