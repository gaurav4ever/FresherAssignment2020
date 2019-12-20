package com.gonuclei.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The type Abstract user subscription.
 */
@MappedSuperclass
public abstract class AbstractUserSubscription {

  /**
   * The Log id.
   */
  @Id
  @Column(name = "log_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long logId;

  /**
   * The Email.
   */
  @Column(name = "user_email")
  private String email;

  /**
   * The Subscription category.
   */
  @Column(name = "subscription_category")
  private String subscriptionCategory;

  /**
   * The Subscription id.
   */
  @Column(name = "subscription_id")
  private Long subscriptionId;

  /**
   * The Date of subscription.
   */
  @Column(name = "date_of_subscription")
  private Date dateOfSubscription;

  /**
   * The Date of expiry.
   */
  @Column(name = "date_of_expiry")
  private Date dateOfExpiry;

  /**
   * The Status.
   */
  @Column(name = "status")
  private int status;

  /**
   * Gets log id.
   *
   * @return the log id
   */
  public Long getLogId() {
    return logId;
  }

  /**
   * Sets log id.
   *
   * @param logId the log id
   */
  public void setLogId(final Long logId) {
    this.logId = logId;
  }

  /**
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * Gets subscription category.
   *
   * @return the subscription category
   */
  public String getSubscriptionCategory() {
    return subscriptionCategory;
  }

  /**
   * Sets subscription category.
   *
   * @param subscriptionCategory the subscription category
   */
  public void setSubscriptionCategory(final String subscriptionCategory) {
    this.subscriptionCategory = subscriptionCategory;
  }

  /**
   * Gets subscription id.
   *
   * @return the subscription id
   */
  public Long getSubscriptionId() {
    return subscriptionId;
  }

  /**
   * Sets subscription id.
   *
   * @param subscriptionId the subscription id
   */
  public void setSubscriptionId(final Long subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  /**
   * Gets date of subscription.
   *
   * @return the date of subscription
   */
  public Date getDateOfSubscription() {
    return dateOfSubscription;
  }

  /**
   * Sets date of subscription.
   *
   * @param dateOfSubscription the date of subscription
   */
  public void setDateOfSubscription(final Date dateOfSubscription) {
    this.dateOfSubscription = dateOfSubscription;
  }

  /**
   * Gets date of expiry.
   *
   * @return the date of expiry
   */
  public Date getDateOfExpiry() {
    return dateOfExpiry;
  }

  /**
   * Sets date of expiry.
   *
   * @param dateOfExpiry the date of expiry
   */
  public void setDateOfExpiry(final Date dateOfExpiry) {
    this.dateOfExpiry = dateOfExpiry;
  }

  /**
   * Gets status.
   *
   * @return the status
   */
  public int getStatus() {
    return status;
  }

  /**
   * Sets status.
   *
   * @param status the status
   */
  public void setStatus(final int status) {
    this.status = status;
  }
}
