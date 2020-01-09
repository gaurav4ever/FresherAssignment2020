package com.gonuclei.bos;

import com.gonuclei.model.AbstractNewsLetterModel;
import com.gonuclei.model.AbstractUserModel;

import java.util.Set;

/**
 * The type User bo.
 */
public class UserBo extends AbstractUserModel {

  private Set<AbstractNewsLetterModel> newsLetters;

  /**
   * Instantiates a new User bo.
   *
   * @param newsLetters the news letters
   */
  public UserBo(Set<AbstractNewsLetterModel> newsLetters) {
    this.newsLetters = newsLetters;
  }

  /**
   * Gets news letters.
   *
   * @return the news letters
   */
  public Set<AbstractNewsLetterModel> getNewsLetters() {
    return newsLetters;
  }

  /**
   * Sets news letters.
   *
   * @param newsLetters the news letters
   */
  public void setNewsLetters(Set<AbstractNewsLetterModel> newsLetters) {
    this.newsLetters = newsLetters;
  }
}
