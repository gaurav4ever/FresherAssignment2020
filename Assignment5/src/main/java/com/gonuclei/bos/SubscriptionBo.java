package com.gonuclei.bos;

import com.gonuclei.model.AbstractNewsLetterModel;
import com.gonuclei.model.AbstractSubscriptionModel;
import com.gonuclei.model.AbstractUserModel;

/**
 * The type Subscription bo.
 */
public class SubscriptionBo extends AbstractSubscriptionModel {

    private AbstractNewsLetterModel newsLetter;
    private AbstractUserModel user;

    /**
     * Instantiates a new Subscription bo.
     */
    public SubscriptionBo() {
    }

    /**
     * Instantiates a new Subscription bo.
     *
     * @param newsLetter the news letter
     * @param user       the user
     */
    public SubscriptionBo(AbstractNewsLetterModel newsLetter, AbstractUserModel user) {
        this.newsLetter = newsLetter;
        this.user = user;
    }

    /**
     * Gets news letter.
     *
     * @return the news letter
     */
    public AbstractNewsLetterModel getNewsLetter() {
        return newsLetter;
    }

    /**
     * Sets news letter.
     *
     * @param newsLetter the news letter
     */
    public void setNewsLetter(AbstractNewsLetterModel newsLetter) {
        this.newsLetter = newsLetter;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public AbstractUserModel getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(AbstractUserModel user) {
        this.user = user;
    }
}
