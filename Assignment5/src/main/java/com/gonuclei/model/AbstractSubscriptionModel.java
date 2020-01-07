package com.gonuclei.model;

import com.gonuclei.enums.SubscriptionStatusEnum;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractSubscriptionModel implements Serializable {

    @Column(name="begin_date", nullable = false)
    private Date subscriptionBeginDate;

    @Column(name="end_date", nullable = false)
    private Date subscriptionEndDate;

    @Column(name="status", nullable = false)
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
