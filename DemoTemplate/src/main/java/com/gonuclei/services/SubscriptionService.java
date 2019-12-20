package com.gonuclei.services;

import com.gonuclei.bo.SubscriptionBo;
import com.gonuclei.exceptions.CustomException;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * The interface Subscription service.
 */
@Component
public interface SubscriptionService {

  /**
   * Gets all subscriptions.
   *
   * @return the all subscriptions
   */
  List<SubscriptionBo> getAllSubscriptions();

  /**
   * Add subscription string.
   *
   * @param subscription the subscription
   * @return the string
   */
  String addSubscription(SubscriptionBo subscription);

  /**
   * Gets subscription by id.
   *
   * @param id the id
   * @return the subscription by id
   * @throws CustomException the custom exception
   */
  SubscriptionBo getSubscriptionById(Long id) throws CustomException;

  /**
   * Search subscriptions based on category list.
   *
   * @param category the category
   * @return the list
   */
  List<SubscriptionBo> searchSubscriptionsBasedOnCategory(String category);

  /**
   * Search subscriptions based on name list.
   *
   * @param name the name
   * @return the list
   */
  List<SubscriptionBo> searchSubscriptionsBasedOnName(String name);

  /**
   * Sort subscription list.
   *
   * @param sortingAttributes the sorting attributes
   * @return the list
   */
  List<SubscriptionBo> sortSubscription(String sortingAttributes);


}
