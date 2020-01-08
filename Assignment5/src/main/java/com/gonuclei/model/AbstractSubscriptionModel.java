package com.gonuclei.model;

import com.gonuclei.enums.SubscriptionStatusEnum;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * The type Abstract subscription model.
 */
@MappedSuperclass
public abstract class AbstractSubscriptionModel implements Serializable {

    @Column(name="begin_date", nullable = false)
    private Date subscriptionBeginDate;

    @Column(name="end_date", nullable = false)
    private Date subscriptionEndDate;

    @Column(name="status", nullable = false)
    private SubscriptionStatusEnum subscriptionState;

    /**
     * Instantiates a new Abstract subscription model.
     */
    public AbstractSubscriptionModel() {
    }

    /**
     * Gets subscription begin date.
     *
     * @return the subscription begin date
     */
    public Date getSubscriptionBeginDate() {
        return subscriptionBeginDate;
    }

    /**
     * Sets subscription begin date.
     *
     * @param subscriptionBeginDate the subscription begin date
     */
    public void setSubscriptionBeginDate(Date subscriptionBeginDate) {
        this.subscriptionBeginDate = subscriptionBeginDate;
    }

    /**
     * Gets subscription end date.
     *
     * @return the subscription end date
     */
    public Date getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    /**
     * Sets subscription end date.
     *
     * @param subscriptionEndDate the subscription end date
     */
    public void setSubscriptionEndDate(Date subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    /**
     * Gets subscription state.
     *
     * @return the subscription state
     */
    public SubscriptionStatusEnum getSubscriptionState() {
        return subscriptionState;
    }

    /**
     * Sets subscription state.
     *
     * @param subscriptionState the subscription state
     */
    public void setSubscriptionState(SubscriptionStatusEnum subscriptionState) {
        this.subscriptionState = subscriptionState;
    }
}
