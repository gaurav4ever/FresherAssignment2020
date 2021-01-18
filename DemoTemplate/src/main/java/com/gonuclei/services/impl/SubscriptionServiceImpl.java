package com.gonuclei.services.impl;

import com.gonuclei.bo.SubscriptionBo;
import com.gonuclei.exceptions.CustomException;
import com.gonuclei.services.SubscriptionService;
import com.gonuclei.transactionServices.SubscriptionTransactionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Subscription service.
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

  /**
   * The Subscription transaction service.
   */
  @Autowired
  SubscriptionTransactionService subscriptionTransactionService;

  /**
   * Gets all subscriptions.
   *
   * @return the all subscriptions
   */
  @Override
  public List<SubscriptionBo> getAllSubscriptions() {

    return subscriptionTransactionService.getAllSubscriptions();
  }

  /**
   * Add subscription string.
   *
   * @param subscription the subscription
   * @return the string
   */
  @Override
  public String addSubscription(SubscriptionBo subscription) {
    try {
      subscriptionTransactionService.addSubscription(subscription);
      return "Succesfully added Subscription";
    } catch (CustomException e) {
      return e.getMessage();
    }

  }

  /**
   * Gets subscription by id.
   *
   * @param id the id
   * @return the subscription by id
   */
  @Override
  public SubscriptionBo getSubscriptionById(Long id) {
    return subscriptionTransactionService.getSusbcriptionById(id);
  }

  /**
   * Search subscriptions based on category list.
   *
   * @param category the category
   * @return the list
   */
  @Override
  public List<SubscriptionBo> searchSubscriptionsBasedOnCategory(String category) {
    return subscriptionTransactionService.findSubscriptionByCategory(category);
  }

  /**
   * Search subscriptions based on name list.
   *
   * @param name the name
   * @return the list
   */
  @Override
  public List<SubscriptionBo> searchSubscriptionsBasedOnName(String name) {
    return subscriptionTransactionService.findSubscriptionByName(name);
  }


  /**
   * Sort subscription list.
   *
   * @param attribute the attribute
   * @return the list
   */
  @Override
  public List<SubscriptionBo> sortSubscription(String attribute) {
    return null;
  }


}
