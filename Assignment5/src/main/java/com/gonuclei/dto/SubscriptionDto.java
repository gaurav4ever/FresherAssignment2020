package com.gonuclei.dto;

import com.gonuclei.model.AbstractSubscriptionModel;

/**
 * The type Subscription dto.
 */
public class SubscriptionDto extends AbstractSubscriptionModel {

  private Long newsLetterId;
  private Long userId;

  /**
   * Gets news letter id.
   *
   * @return the news letter id
   */
  public Long getNewsLetterId() {
    return newsLetterId;
  }

  /**
   * Sets news letter id.
   *
   * @param newsLetterId the news letter id
   */
  public void setNewsLetterId(Long newsLetterId) {
    this.newsLetterId = newsLetterId;
  }

  /**
   * Gets user id.
   *
   * @return the user id
   */
  public Long getUserId() {
    return userId;
  }

  /**
   * Sets user id.
   *
   * @param userId the user id
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
