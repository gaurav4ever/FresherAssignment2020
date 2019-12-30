package com.gonuclei.services.impl;

import com.gonuclei.exceptions.DbNotModifiedException;
import com.gonuclei.exceptions.SubscriptionNotFoundException;
import com.gonuclei.models.bo.SubscriptionBo;
import com.gonuclei.services.SubscriptionService;
import com.gonuclei.transactionService.SubscriptionTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Subscription service.
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

  /**
   * The Subscription transaction service.
   */
  @Autowired
  private SubscriptionTransactionService subscriptionTransactionService;

  /**
   * Gets all subscriptions.
   *
   * @return the all subscriptions
   */
  @Override
  public List<SubscriptionBo> getAllSubscriptions() {
    List<SubscriptionBo> subscriptionBo = subscriptionTransactionService.getAllSubscriptions();
    if (subscriptionBo == null || subscriptionBo.isEmpty()) {
      throw new SubscriptionNotFoundException("No subscriptions found!", HttpStatus.BAD_REQUEST);
    } else {
      return subscriptionBo;
    }
  }

  /**
   * Add subscription boolean.
   *
   * @param subscription the subscription
   * @return the boolean
   */
  @Override
  public boolean addSubscription(SubscriptionBo subscription) {
    if (subscriptionTransactionService.addSubscription(subscription)) {
      return true;
    } else {
      throw new DbNotModifiedException("Subscription could not be modified",
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * Search subscriptions by category list.
   *
   * @param category the category
   * @return the list
   */
  @Override
  public List<SubscriptionBo> searchSubscriptionsByCategory(String category) {
    List<SubscriptionBo> subscriptionBo = subscriptionTransactionService.searchByCategory(category);
    if (subscriptionBo == null || subscriptionBo.isEmpty()) {
      throw new SubscriptionNotFoundException("Subscription not found by this category",
        HttpStatus.BAD_REQUEST);
    } else {
      return subscriptionBo;
    }
  }

  /**
   * Search subscriptions by name subscription bo.
   *
   * @param name the name
   * @return the subscription bo
   */
  @Override
  public SubscriptionBo searchSubscriptionsByName(String name) {
    SubscriptionBo subscriptionBo = subscriptionTransactionService.searchByName(name);
    if (subscriptionBo != null) {
      return subscriptionBo;
    } else {
      throw new SubscriptionNotFoundException("Subscription not found by this name!",
        HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Sort subscription by validity list.
   *
   * @param validity the validity
   * @return the list
   */
  @Override
  public List<SubscriptionBo> sortSubscriptionByValidity(int validity) {
    return null;
  }

  /**
   * Sort subscription by price list.
   *
   * @param validity the validity
   * @return the list
   */
  @Override
  public List<SubscriptionBo> sortSubscriptionByPrice(int validity) {
    return null;
  }
}
