package com.gonuclei.bos;

import com.gonuclei.model.AbstractNewsLetterModel;
import com.gonuclei.model.AbstractUserModel;

import java.util.Set;

public class UserBo extends AbstractUserModel {

    private Set<AbstractNewsLetterModel> subscriptions;

    public UserBo(Set<AbstractNewsLetterModel> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Set<AbstractNewsLetterModel> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<AbstractNewsLetterModel> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
