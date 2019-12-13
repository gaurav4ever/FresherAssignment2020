package com.newsletter.newsletter.model;

import java.util.Date;


public class SubscriptionDto {
	private long subscriptionid; 
	private String email;
	private Date endDateOfSubscription;
	private String newsLetterType;
	private Date dateOfSubscription;
	private String dailyweekly;
	private byte isSubscribed;
	private byte isCanceled;
	private byte isRenewed;
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
	@Override
	public String toString() {
		return "SubscriptionDto [subscriptionid=" + subscriptionid + ", email=" + email + ", endDateOfSubscription="
				+ endDateOfSubscription + ", newsLetterType=" + newsLetterType + ", dateOfSubscription="
				+ dateOfSubscription + ", dailyweekly=" + dailyweekly + ", isSubscribed=" + isSubscribed
				+ ", isCanceled=" + isCanceled + ", isRenewed=" + isRenewed + ", id=" + id + "]";
	}
}
