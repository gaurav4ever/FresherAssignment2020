package com.example.demo.Model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Subscription")
public class Subscription {
    public Subscription() {
    }

    public Subscription(int subscriptionId, int userId, String userName, int newsLetterId, String newsLetterName) {
        this.subscriptionId = subscriptionId;
        this.userId = userId;
        this.userName = userName;
        this.newsLetterId = newsLetterId;
        this.newsLetterName = newsLetterName;
    }


    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNewsLetterId() {
        return newsLetterId;
    }

    public void setNewsLetterId(int newsLetterId) {
        this.newsLetterId = newsLetterId;
    }

    public String getNewsLetterName() {
        return newsLetterName;
    }

    public void setNewsLetterName(String newsLetterName) {
        this.newsLetterName = newsLetterName;
    }

    @Id
    int subscriptionId;

    int userId;

    String userName;

    int newsLetterId;

    String newsLetterName;



}
