package com.gonuclei.controllers;

import com.gonuclei.exceptions.SubscriptionNotFoundException;
import com.gonuclei.exceptions.UserNotFoundException;
import com.gonuclei.services.impl.UserSubscriptionServiceImpl;
import com.gonuclei.mapper.UserSubscriptionObjectMapper;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User subscription controller.
 */
@RestController
@RequestMapping(path = "/userSubscription")
public class UserSubscriptionController {

  /**
   * The User subscription service.
   */
  @Autowired
  private UserSubscriptionServiceImpl userSubscriptionService;

  /**
   * The User subscription object mapper.
   */
  @Autowired
  private UserSubscriptionObjectMapper userSubscriptionObjectMapper;

  /**
   * Buy subscription response entity.
   *
   * @param subscriptionId     the subscription id
   * @param httpServletRequest the http servlet request
   * @return the response entity
   */
  @PostMapping(path = "/buySubscription")
  private ResponseEntity<String> buySubscription(@RequestParam Long subscriptionId,
                                                 HttpServletRequest httpServletRequest) {
    if (userSubscriptionService.buySubscription(subscriptionId, httpServletRequest)) {
      return new ResponseEntity<>("User brought subscription successfully!", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Could not buy subscription!", HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Gets subscriptions.
   *
   * @param httpServletRequest the http servlet request
   * @return the subscriptions
   * @throws UserNotFoundException the user not found exception
   */
  @GetMapping(path = "/getSubscriptions")
  private ResponseEntity<?> getSubscriptions(
    HttpServletRequest httpServletRequest) {
    try {
      return new ResponseEntity<>(userSubscriptionObjectMapper.getUserSubscriptionDtofromBoList(
        userSubscriptionService.viewUserSubscription(httpServletRequest)), HttpStatus.OK);
    } catch (SubscriptionNotFoundException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
  }

  /**
   * Delete user subscription response entity.
   *
   * @param subscriptionId     the subscription id
   * @param httpServletRequest the http servlet request
   * @return the response entity
   */
  @RequestMapping(path = "/deleteSubscription")
  private ResponseEntity<?> deleteUserSubscription(
    @RequestParam Long subscriptionId, HttpServletRequest httpServletRequest) {
    try {
      return new ResponseEntity<>(userSubscriptionService
        .deleteSubscription(subscriptionId, httpServletRequest), HttpStatus.OK);
    } catch (SubscriptionNotFoundException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
  }

  /**
   * Renew user subscription response entity.
   *
   * @param subscriptionId     the subscription id
   * @param httpServletRequest the http servlet request
   * @return the response entity
   */
  @RequestMapping(path = "/renewSubscription")
  private ResponseEntity<?> renewUserSubscription(@RequestParam Long subscriptionId,
                                                  HttpServletRequest httpServletRequest) {
    return new ResponseEntity<>(
      userSubscriptionService.renewSubscription(subscriptionId, httpServletRequest), HttpStatus.OK);
  }
}
