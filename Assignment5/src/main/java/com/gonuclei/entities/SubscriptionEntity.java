package com.gonuclei.entities;

import com.gonuclei.model.AbstractSubscriptionModel;

import javax.persistence.*;
import java.util.Objects;

@Entity(name="Subscription")
@Table(name="user_subscriptions")
public class SubscriptionEntity extends AbstractSubscriptionModel {

  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn
  @MapsId("newsLetterId")
  private NewsLetterEntity newsLetter;

  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn
  @MapsId("userId")
  private UserEntity user;

  public SubscriptionEntity() {
  }

  public NewsLetterEntity getNewsLetter() {
    return newsLetter;
  }

  public void setNewsLetter(NewsLetterEntity newsLetterEntityLetter) {
    this.newsLetter = newsLetterEntityLetter;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity userEntity) {
    this.user = userEntity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SubscriptionEntity)) return false;
    SubscriptionEntity that = (SubscriptionEntity) o;
    return Objects.equals(user.getId(), that.user.getId()) &&
        Objects.equals(newsLetter.getId(), that.newsLetter.getId()) &&
        Objects.equals(getSubscriptionEndDate(), that.getSubscriptionEndDate()) &&
        Objects.equals(getSubscriptionBeginDate(), that.getSubscriptionBeginDate()) &&
        Objects.equals(getSubscriptionState(), that.getSubscriptionState());
  }

  @Override
  public int hashCode() {
    return Objects.hash(user.getId(), newsLetter.getId(), getSubscriptionEndDate(), getSubscriptionBeginDate(), getSubscriptionState() );
  }
}
