package com.gonuclei.bos;

import com.gonuclei.model.AbstractNewsLetterModel;
import com.gonuclei.model.AbstractSubscriptionModel;
import com.gonuclei.model.AbstractUserModel;

public class SubscriptionBo extends AbstractSubscriptionModel {

    private AbstractNewsLetterModel newsLetter;
    private AbstractUserModel user;

    public SubscriptionBo() {
    }

    public SubscriptionBo(AbstractNewsLetterModel newsLetter, AbstractUserModel user) {
        this.newsLetter = newsLetter;
        this.user = user;
    }

    public AbstractNewsLetterModel getNewsLetter() {
        return newsLetter;
    }

    public void setNewsLetter(AbstractNewsLetterModel newsLetter) {
        this.newsLetter = newsLetter;
    }

    public AbstractUserModel getUser() {
        return user;
    }

    public void setUser(AbstractUserModel user) {
        this.user = user;
    }
}
