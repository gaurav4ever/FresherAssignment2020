package com.gonuclei.bos;

import com.gonuclei.model.AbstractNewsLetterModel;
import com.gonuclei.model.AbstractUserModel;

import java.util.Set;

/**
 * The type News letter bo.
 */
public class NewsLetterBo extends AbstractNewsLetterModel {

    private Set<AbstractUserModel> subscribedUsers;

    /**
     * Instantiates a new News letter bo.
     */
    public NewsLetterBo() {

    }

    /**
     * Gets subscribed users.
     *
     * @return the subscribed users
     */
    public Set<AbstractUserModel> getSubscribedUsers() {
        return subscribedUsers;
    }

    /**
     * Sets subscribed users.
     *
     * @param subscribedUsers the subscribed users
     */
    public void setSubscribedUsers(Set<AbstractUserModel> subscribedUsers) {
        this.subscribedUsers = subscribedUsers;
    }
}
