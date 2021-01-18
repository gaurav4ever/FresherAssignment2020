package com.gonuclei.controllers;

import com.gonuclei.exceptions.DbNotModifiedException;
import com.gonuclei.exceptions.SubscriptionNotFoundException;
import com.gonuclei.models.bo.SubscriptionBo;
import com.gonuclei.models.dto.SubscriptionResponse;
import com.gonuclei.services.SubscriptionService;
import com.gonuclei.mapper.SubscriptionObjectMapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type Subscription controller.
 */
@RestController
@RequestMapping(path = "/")
public class SubscriptionController {

  /**
   * The Logger.
   */
  private final static Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

  /**
   * The Subscription service.
   */
  @Autowired
  private SubscriptionService subscriptionService;

  /**
   * The Subscription object mapper.
   */
  @Autowired
  private SubscriptionObjectMapper subscriptionObjectMapper;

  /**
   * Gets all subscriptions.
   *
   * @return the all subscriptions
   * @throws SubscriptionNotFoundException the subscription not found exception
   */
//get all subscriptions
  @GetMapping(path = "getSubscriptions")
  public ResponseEntity<?> getAllSubscriptions()
    throws SubscriptionNotFoundException {
    try {
      List<SubscriptionBo> subscriptionBoList = subscriptionService.getAllSubscriptions();
      return new ResponseEntity<>(
        subscriptionObjectMapper.getSubscriptionResponseFromBoList(subscriptionBoList),
        HttpStatus.OK);
    } catch (SubscriptionNotFoundException e) {
      logger.error("Could not get subscription list!" + e);
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
  }

  /**
   * Gets subscriptions by name.
   *
   * @param name the name
   * @return the subscriptions by name
   */
  @GetMapping(path = "searchSubscription/byName")
  public ResponseEntity<?> getSubscriptionsByName(@RequestParam String name) {
    try {
      SubscriptionBo subscriptionBO = subscriptionService.searchSubscriptionsByName(name);
      return new ResponseEntity<>(subscriptionObjectMapper.boToDto(subscriptionBO), HttpStatus.OK);
    } catch (SubscriptionNotFoundException e) {
      logger.error("Could not get any subscriptions by this name! " + e);
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
  }

  /**
   * Gets subscription by category.
   *
   * @param category the category
   * @return the subscription by category
   */
  @GetMapping(path = "searchSubscription/byCategory")
  public ResponseEntity<?> getSubscriptionByCategory(@RequestParam String category) {
    try {
      List<SubscriptionBo> subscriptionBoList = subscriptionService
        .searchSubscriptionsByCategory(category);
      return new ResponseEntity<>(
        subscriptionObjectMapper.getSubscriptionResponseFromBoList(subscriptionBoList),
        HttpStatus.OK);
    } catch (SubscriptionNotFoundException e) {
      logger.error("Could not get any subscriptions by this category! " + e);
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
  }

  /**
   * Add subscription response entity.
   *
   * @param subscriptionResponse the subscription response
   * @return the response entity
   */
  @PostMapping(path = "addSubscription")
  public ResponseEntity<?> addSubscription(@RequestBody SubscriptionResponse subscriptionResponse) {
    try {
      subscriptionService.addSubscription(subscriptionObjectMapper.dtoToBo(subscriptionResponse));
      return new ResponseEntity<>("Subscription added successfully!", HttpStatus.OK);
    } catch (DbNotModifiedException e) {
      logger.error("Could not add given subscription to the db!" + e);
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
  }
}
