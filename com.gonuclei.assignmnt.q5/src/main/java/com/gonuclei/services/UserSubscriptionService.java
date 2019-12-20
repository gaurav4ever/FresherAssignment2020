package com.gonuclei.services;

import com.gonuclei.bo.NewsLetterBo;
import com.gonuclei.bo.UserSubscriptionBo;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

/**
 * The interface User subscription service.
 */
@Component
public interface UserSubscriptionService {

  /**
   * Buy subscription boolean.
   *
   * @param susbcriptionId the susbcription id
   * @param request        the request
   * @return the boolean
   */
  boolean buySubscription(Long susbcriptionId, HttpServletRequest request);

  /**
   * Renew subscription boolean.
   *
   * @param subscritionId the subscrition id
   * @param request       the request
   * @return the boolean
   */
  boolean renewSubscription(Long subscritionId, HttpServletRequest request);

  /**
   * Delete subscription boolean.
   *
   * @param subscriptionId the subscription id
   * @param request        the request
   * @return the boolean
   */
  boolean deleteSubscription(Long subscriptionId, HttpServletRequest request);

  /**
   * Gets user subscriptions.
   *
   * @param request the request
   * @return the user subscriptions
   */
  List<UserSubscriptionBo> getUserSubscriptions(HttpServletRequest request);

  /**
   * Send news letter boolean.
   *
   * @param newsLetterBO the news letter bo
   * @return the boolean
   */
  void sendNewsLetter(NewsLetterBo newsLetterBO);

}
