package com.gonuclei.services;

import com.gonuclei.models.bo.UserSubscriptionBo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * The interface User subscription service.
 */
@Service
public interface UserSubscriptionService {

  /**
   * Buy subscription boolean.
   *
   * @param subscriptionId     the subscription id
   * @param httpServletRequest the http servlet request
   * @return the boolean
   */
//buy a subscription
  boolean buySubscription(Long subscriptionId, HttpServletRequest httpServletRequest);

  /**
   * Delete subscription boolean.
   *
   * @param subscriptionId     the subscription id
   * @param httpServletRequest the http servlet request
   * @return the boolean
   */
//delete subscription
  boolean deleteSubscription(Long subscriptionId, HttpServletRequest httpServletRequest);

  /**
   * Renew subscription boolean.
   *
   * @param subscriptionId     the subscription id
   * @param httpServletRequest the http servlet request
   * @return the boolean
   */
// renew subscription by increasing the validity period
  boolean renewSubscription(Long subscriptionId, HttpServletRequest httpServletRequest);

  /**
   * View user subscription list.
   *
   * @param httpServletRequest the http servlet request
   * @return the list
   */
//view subscriptions subscribed by the logged in user
  List<UserSubscriptionBo> viewUserSubscription(HttpServletRequest httpServletRequest);

  /**
   * Update subscription status.
   */
  void updateSubscriptionStatus();

}
