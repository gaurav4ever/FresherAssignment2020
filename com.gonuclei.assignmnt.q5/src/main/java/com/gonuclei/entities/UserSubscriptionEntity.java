package com.gonuclei.entities;

import com.gonuclei.models.AbstractUserSubscription;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The type User subscription entity.
 */
@Entity
@Table(name = "user_subscriptions")
public class UserSubscriptionEntity extends AbstractUserSubscription {

}
