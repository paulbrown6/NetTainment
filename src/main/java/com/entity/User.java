package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Paul Brown on 21.12.2016.
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", length = 64)
    private String firstname;

    @Column(name = "lastName", length = 64)
    private String lastname;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "login", length = 64, unique = true)
    private String login;

    @Column(name = "password", length = 64)
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userID")
    private List<News> sentNews;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userID")
    private List<Video> sentVideos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userID")
    private List<Book> sentBooks;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userID")
    private List<Audio> sentAudios;

    public User() {
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Video> getSentVideos() {
        return sentVideos;
    }

    public void setSentVideos(List<Video> sentVideos) {
        this.sentVideos = sentVideos;
    }

    public List<Book> getSentBooks() {
        return sentBooks;
    }

    public void setSentBooks(List<Book> sentBooks) {
        this.sentBooks = sentBooks;
    }

    public List<Audio> getSentAudios() {
        return sentAudios;
    }

    public void setSentAudios(List<Audio> sentAudios) {
        this.sentAudios = sentAudios;
    }



    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
