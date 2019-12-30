package com.gonuclei.services.impl;

import com.gonuclei.constants.Constants;
import com.gonuclei.exceptions.SubscriptionNotFoundException;
import com.gonuclei.models.bo.SubscriptionBo;
import com.gonuclei.models.bo.UserSubscriptionBo;
import com.gonuclei.security.JwtUtil;
import com.gonuclei.services.UserSubscriptionService;
import com.gonuclei.transactionService.SubscriptionTransactionService;
import com.gonuclei.transactionService.UserSubscriptionTransactionService;
import com.gonuclei.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type User subscription service.
 */
@Service
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

  /**
   * The Jwt util.
   */
  @Autowired
  private JwtUtil jwtUtil;

  /**
   * The User subscription transaction service.
   */
  @Autowired
  private UserSubscriptionTransactionService userSubscriptionTransactionService;

  /**
   * The Subscription transaction service.
   */
  @Autowired
  private SubscriptionTransactionService subscriptionTransactionService;

  /**
   * The Sender.
   */
  @Autowired
  private JavaMailSender sender;

  /**
   * Buy subscription boolean.
   *
   * @param subscriptionId     the subscription id
   * @param httpServletRequest the http servlet request
   * @return the boolean
   */
  @Override
  public boolean buySubscription(Long subscriptionId, HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader(Constants.AUTHORIZATION);
    String emailId = jwtUtil.extractUsername(token.substring(Constants.JWT_TOKEN_SUBSTRING));

    //assign current date as date of subscription
    Date dos = new Date();

    //get date of expiry from Subscription table's validity
    SubscriptionBo subscriptionBo = subscriptionTransactionService
      .getSubscriptionById(subscriptionId).get();
    int validity = subscriptionBo.getValidity();

    // extract subscription name from given subscription
    String sub_category = subscriptionBo.getName();

    //status of subscription is active
    boolean status = true;

    UserSubscriptionBo userSubscriptionBo = new UserSubscriptionBo();
    userSubscriptionBo.setEmailId(emailId);
    userSubscriptionBo.setSubscriptionId(subscriptionId);
    userSubscriptionBo.setDateOfSubscription(dos);
    userSubscriptionBo.setDateOfExpiry(DateUtil.getDateOfExpiry(validity));
    userSubscriptionBo.setStatus(status);
    userSubscriptionBo.setSubscriptionCategory(sub_category);

    return userSubscriptionTransactionService.buySubscription(userSubscriptionBo);
  }

  /**
   * Delete subscription boolean.
   *
   * @param subscriptionId     the subscription id
   * @param httpServletRequest the http servlet request
   * @return the boolean
   */
  @Override
  public boolean deleteSubscription(Long subscriptionId, HttpServletRequest httpServletRequest) {
    if (userSubscriptionTransactionService
      .deleteSubscription(getEmailIdFromToken(httpServletRequest), subscriptionId)) {
      return true;
    } else {
      throw new SubscriptionNotFoundException("Could not find subscription!",
        HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Renew subscription boolean.
   *
   * @param subscriptionId     the subscription id
   * @param httpServletRequest the http servlet request
   * @return the boolean
   */
  @Override
  public boolean renewSubscription(Long subscriptionId, HttpServletRequest httpServletRequest) {
    if (userSubscriptionTransactionService
      .renewSubscription(getEmailIdFromToken(httpServletRequest), subscriptionId) != null) {
      return true;
    } else {
      throw new SubscriptionNotFoundException("Could not find subscription!",
        HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * View user subscription list.
   *
   * @param httpServletRequest the http servlet request
   * @return the list
   */
  @Override
  public List<UserSubscriptionBo> viewUserSubscription(HttpServletRequest httpServletRequest) {
    List<UserSubscriptionBo> userSubscriptionBo = userSubscriptionTransactionService
      .getAllUserSubscriptions(getEmailIdFromToken(httpServletRequest));

    if (userSubscriptionBo != null) {
      return userSubscriptionBo;
    } else {
      throw new SubscriptionNotFoundException("Could not find subscription!",
        HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Update subscription status.
   */
  @Override
  public void updateSubscriptionStatus() {
    Date currDate = new Date();
    List<UserSubscriptionBo> userSubscriptionBosExpired = userSubscriptionTransactionService
      .getAllUserSubscriptions()
      .stream()
      .filter(userSubscriptionBo -> userSubscriptionBo
      .getDateOfExpiry().compareTo(currDate)<0).collect(Collectors.toList());

    userSubscriptionTransactionService.updateStatus(userSubscriptionBosExpired);
  }

  /**
   * Gets email id from token.
   *
   * @param httpServletRequest the http servlet request
   * @return the email id from token
   */
  private String getEmailIdFromToken(HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader(Constants.AUTHORIZATION);
    return jwtUtil.extractUsername(token.substring(Constants.JWT_TOKEN_SUBSTRING));
  }
}
