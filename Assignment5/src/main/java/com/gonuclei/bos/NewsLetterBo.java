package com.gonuclei.bos;

import com.gonuclei.model.AbstractNewsLetterModel;
import com.gonuclei.model.AbstractUserModel;

import java.util.Set;

public class NewsLetterBo extends AbstractNewsLetterModel {

    private Set<AbstractUserModel> subscribedUsers;

    public NewsLetterBo() {

    }

    public Set<AbstractUserModel> getSubscribedUsers() {
        return subscribedUsers;
    }

    public void setSubscribedUsers(Set<AbstractUserModel> subscribedUsers) {
        this.subscribedUsers = subscribedUsers;
    }
}
