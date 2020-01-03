package com.gonuclei.model;

import com.gonuclei.enums.SubscriptionStatusEnum;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractSubscriptionModel {

    private Date subscriptionBeginDate;
    private Date subscriptionEndDate;
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
