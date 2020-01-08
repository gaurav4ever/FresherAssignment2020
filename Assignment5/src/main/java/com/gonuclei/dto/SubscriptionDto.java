package com.gonuclei.dto;

import com.gonuclei.model.AbstractSubscriptionModel;

public class SubscriptionDto extends AbstractSubscriptionModel {

  private Long newsLetterId;
  private Long userId;

  public Long getNewsLetterId() {
    return newsLetterId;
  }

  public void setNewsLetterId(Long newsLetterId) {
    this.newsLetterId = newsLetterId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
