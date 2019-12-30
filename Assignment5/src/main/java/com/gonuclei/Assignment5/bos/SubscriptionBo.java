package com.gonuclei.Assignment5.bos;

import com.gonuclei.Assignment5.model.AbstractSubscriptionModel;
import com.gonuclei.Assignment5.model.AbstractUserModel;

import java.util.Set;

public class SubscriptionBo extends AbstractSubscriptionModel {

    private Set<AbstractUserModel> subscribedUsers;

    public SubscriptionBo(Set<AbstractUserModel> subscribedUsers) {
        this.subscribedUsers = subscribedUsers;
    }

    public Set<AbstractUserModel> getSubscribedUsers() {
        return subscribedUsers;
    }

    public void setSubscribedUsers(Set<AbstractUserModel> subscribedUsers) {
        this.subscribedUsers = subscribedUsers;
    }
}
