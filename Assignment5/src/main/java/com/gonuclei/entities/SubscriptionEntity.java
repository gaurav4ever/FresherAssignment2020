package com.gonuclei.entities;

import com.gonuclei.model.AbstractSubscriptionModel;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Subscription entity.
 */
@Entity(name="Subscription")
@Table(name="user_subscriptions")
public class SubscriptionEntity extends AbstractSubscriptionModel {

  //@Id
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  //@MapsId("newsLetterId")
  private NewsLetterEntity newsLetter;

  //@Id
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  //@MapsId("userId")
  private UserEntity user;

  /**
   * Instantiates a new Subscription entity.
   */
  public SubscriptionEntity() {
  }

  /**
   * Gets news letter.
   *
   * @return the news letter
   */
  public NewsLetterEntity getNewsLetter() {
    return newsLetter;
  }

  /**
   * Sets news letter.
   *
   * @param newsLetterEntityLetter the news letter entity letter
   */
  public void setNewsLetter(NewsLetterEntity newsLetterEntityLetter) {
    this.newsLetter = newsLetterEntityLetter;
  }

  /**
   * Gets user.
   *
   * @return the user
   */
  public UserEntity getUser() {
    return user;
  }

  /**
   * Sets user.
   *
   * @param userEntity the user entity
   */
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
