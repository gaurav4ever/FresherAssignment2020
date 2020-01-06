package com.newsletter.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SubscriptionModel {

  //currently i am sending id from frontend
  @Id
  private long subscriptionid;

  @Override
  public String toString() {
    return "Subscription [subscriptionid=" + subscriptionid + ", email=" + email
        + ", endDateOfSubscription="
        + endDateOfSubscription + ", newsLetterType=" + newsLetterType + ", dateOfSubscription="
        + dateOfSubscription + ", dailyweekly=" + dailyweekly + ", isSubscribed=" + isSubscribed
        + ", isCanceled=" + isCanceled + ", isRenewed=" + isRenewed + ", id=" + id + "]";
  }

  private String email;
  @Column(name = "enddateofsubscription")
  private Date endDateOfSubscription;
  @Column(name = "newslettertype")
  private String newsLetterType;
  @Column(name = "dateofsubscription")
  private Date dateOfSubscription;
  private String dailyweekly;
  //below 3 will take either 0 or 1
  @Column(name = "issubscribed")
  private byte isSubscribed;
  @Column(name = "iscanceled")
  private byte isCanceled;
  @Column(name = "isrenewed")
  private byte isRenewed;
  //this is the key to newletterdetail table for content
  private int id;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getEndDateOfSubscription() {
    return endDateOfSubscription;
  }

  public void setEndDateOfSubscription(Date endDateOfSubscription) {
    this.endDateOfSubscription = endDateOfSubscription;
  }

  public String getNewsLetterType() {
    return newsLetterType;
  }

  public void setNewsLetterType(String newsLetterType) {
    this.newsLetterType = newsLetterType;
  }

  public Date getDateOfSubscription() {
    return dateOfSubscription;
  }

  public void setDateOfSubscription(Date dateOfSubscription) {
    this.dateOfSubscription = dateOfSubscription;
  }

  public String getDailyweekly() {
    return dailyweekly;
  }

  public void setDailyweekly(String dailyweekly) {
    this.dailyweekly = dailyweekly;
  }

  public byte getIsSubscribed() {
    return isSubscribed;
  }

  public void setIsSubscribed(byte isSubscribed) {
    this.isSubscribed = isSubscribed;
  }

  public byte getIsCanceled() {
    return isCanceled;
  }

  public void setIsCanceled(byte isCanceled) {
    this.isCanceled = isCanceled;
  }

  public byte getIsRenewed() {
    return isRenewed;
  }

  public void setIsRenewed(byte isRenewed) {
    this.isRenewed = isRenewed;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getSubscriptionid() {
    return subscriptionid;
  }

  public void setSubscriptionid(long subscriptionid) {
    this.subscriptionid = subscriptionid;
  }
}
