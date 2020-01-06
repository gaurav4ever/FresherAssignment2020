package com.gonuclei.model;

import com.gonuclei.enums.SubscriptionStatusEnum;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractSubscriptionModel {

    @Column(name="subscription_begin_date", nullable = false)
    private Date subscriptionBeginDate;

    @Column(name="subscription_begin_date", nullable = false)
    private Date subscriptionEndDate;

    @Column(name="subscription_status", nullable = false)
    private SubscriptionStatusEnum subscriptionState;

    public AbstractSubscriptionModel() {
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

    public void setSubscriptionState(SubscriptionStatusEnum subscriptionState) {
        this.subscriptionState = subscriptionState;
    }
}
