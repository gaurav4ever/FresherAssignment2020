package com.gonuclei.services;

import com.gonuclei.models.bo.SubscriptionBo;

import java.util.List;

/**
 * The interface Subscription service.
 */
public interface SubscriptionService {

  /**
   * Gets all subscriptions.
   *
   * @return the all subscriptions
   */
//get subscriptions list
  List<SubscriptionBo> getAllSubscriptions();

  /**
   * Add subscription boolean.
   *
   * @param subscriptionBo the subscription bo
   * @return the boolean
   */
//add new subscription to the db
  boolean addSubscription(SubscriptionBo subscriptionBo);

  /**
   * Search subscriptions by category list.
   *
   * @param category the category
   * @return the list
   */
//search subscription by category
  List<SubscriptionBo> searchSubscriptionsByCategory(String category);

  /**
   * Search subscriptions by name subscription bo.
   *
   * @param name the name
   * @return the subscription bo
   */
//search subscriptions by name
  SubscriptionBo searchSubscriptionsByName(String name);

  /**
   * Sort subscription by validity list.
   *
   * @param validity the validity
   * @return the list
   */
//sort subscription on basis of validity
  List<SubscriptionBo> sortSubscriptionByValidity(int validity);

  /**
   * Sort subscription by price list.
   *
   * @param validity the validity
   * @return the list
   */
//sort subscription on basis of price
  List<SubscriptionBo> sortSubscriptionByPrice(int validity);
}
