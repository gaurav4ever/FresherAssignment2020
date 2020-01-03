package com.gonuclei.bos;

import com.gonuclei.model.AbstractNewsLetterModel;
import com.gonuclei.model.AbstractUserModel;

import java.util.Set;

public class UserBo extends AbstractUserModel {

    private Set<AbstractNewsLetterModel> newsLetters;

    public UserBo(Set<AbstractNewsLetterModel> newsLetters) {
        this.newsLetters = newsLetters;
    }

    public Set<AbstractNewsLetterModel> getNewsLetters() {
        return newsLetters;
    }

    public void setNewsLetters(Set<AbstractNewsLetterModel> newsLetters) {
        this.newsLetters = newsLetters;
    }
}
