package com.gonuclei.Assignment5.bos;

import com.gonuclei.Assignment5.model.AbstractSubscriptionModel;
import com.gonuclei.Assignment5.model.AbstractUserModel;

import java.util.Set;

public class UserBo extends AbstractUserModel {

    private Set<AbstractSubscriptionModel> subscriptions;

    public UserBo(Set<AbstractSubscriptionModel> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Set<AbstractSubscriptionModel> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<AbstractSubscriptionModel> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
