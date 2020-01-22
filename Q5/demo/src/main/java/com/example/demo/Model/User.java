package com.example.demo.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String emailId;

//    @ManyToMany
//    @JoinTable(
//            name = "User_Subscriptions",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "newsLetter_id")
//    )Set<NewsLetter> subscribedNewsLetters;

//    @OneToMany(mappedBy = "newsletterId")
//    Set<Subscription> subscriptions;

    public User(String emailId) {
        this.emailId = emailId;
    }

    public User(int userId) {
        this.userId = userId;
    }

    public User(int userId, String emailId) {
        this.userId = userId;
        this.emailId = emailId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public User() {
    }
}
