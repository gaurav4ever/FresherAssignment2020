package com.gonuclei.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The type Abstract user subscription model.
 */
@MappedSuperclass
public abstract class AbstractUserSubscriptionModel {

  /**
   * The Id.
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * The Email id.
   */
  @Column(name = "user_email")
  private String emailId;

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
  private boolean status;

  /**
   * The Subscription category.
   */
  @Column(name = "subscription_category")
  private String subscriptionCategory;

  /**
   * Instantiates a new Abstract user subscription model.
   */
  public AbstractUserSubscriptionModel() {

  }

  /**
   * Instantiates a new Abstract user subscription model.
   *
   * @param id                   the id
   * @param emailId              the email id
   * @param subscriptionId       the subscription id
   * @param dateOfSubscription   the date of subscription
   * @param dateOfExpiry         the date of expiry
   * @param status               the status
   * @param subscriptionCategory the subscription category
   */
  public AbstractUserSubscriptionModel(Long id, String emailId, Long subscriptionId,
    Date dateOfSubscription,
    Date dateOfExpiry, boolean status, String subscriptionCategory) {
    this.id = id;
    this.emailId = emailId;
    this.subscriptionId = subscriptionId;
    this.dateOfSubscription = dateOfSubscription;
    this.dateOfExpiry = dateOfExpiry;
    this.status = status;
    this.subscriptionCategory = subscriptionCategory;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * Gets email id.
   *
   * @return the email id
   */
  public String getEmailId() {
    return emailId;
  }

  /**
   * Sets email id.
   *
   * @param emailId the email id
   */
  public void setEmailId(final String emailId) {
    this.emailId = emailId;
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
   * Is status boolean.
   *
   * @return the boolean
   */
  public boolean isStatus() {
    return status;
  }

  /**
   * Sets status.
   *
   * @param status the status
   */
  public void setStatus(final boolean status) {
    this.status = status;
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
}
