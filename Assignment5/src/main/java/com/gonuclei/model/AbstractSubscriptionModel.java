package com.gonuclei.model;

import com.gonuclei.entities.NewsLetterEntity;
import com.gonuclei.entities.UserEntity;
import com.gonuclei.enums.SubscriptionStatusEnum;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractSubscriptionModel {

    @Id
    @ManyToOne
    @JoinColumn
    private UserEntity user;

    @Id
    @ManyToOne
    @JoinColumn
    private NewsLetterEntity newsLetter;

    private Date subscriptionBeginDate;
    private Date subscriptionEndDate;
    private SubscriptionStatusEnum subscriptionState;

    public AbstractSubscriptionModel() {
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public NewsLetterEntity getNewsLetter() {
        return newsLetter;
    }

    public void setNewsLetter(NewsLetterEntity newsLetter) {
        this.newsLetter = newsLetter;
    }

    public Date getSubscriptionBeginDate() {
        return subscriptionBeginDate;
    }

    public void setSubscriptionBeginDate(Date subscriptionBeginDate) {
        this.subscriptionBeginDate = subscriptionBeginDate;
    }

    public Date getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(Date subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public SubscriptionStatusEnum getSubscriptionState() {
        return subscriptionState;
    }

    public void setSubscriptionState(SubscriptionStatusEnum state) {
        this.subscriptionState = state;
    }
}
