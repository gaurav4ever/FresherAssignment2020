package com.gonuclei.controllers;

import com.gonuclei.bo.NewsLetterBo;
import com.gonuclei.bo.SubscriptionBo;
import com.gonuclei.constants.Constants;
import com.gonuclei.dto.NewsLetterDto;
import com.gonuclei.dto.SubscriptionDto;
import com.gonuclei.kafka.MyProducer;
import com.gonuclei.services.SubscriptionService;
import com.gonuclei.services.UserSubscriptionService;
import com.gonuclei.utils.ScheduledTasks;
import com.google.gson.Gson;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Subscription controller.
 */


@RestController
@RequestMapping(path = "/subscription")
class SubscriptionController {

  @Autowired
  private MyProducer producer;
  /**
   * The Model mapper.
   */
  private ModelMapper modelMapper = new ModelMapper();

  private final Gson gson ;

  public SubscriptionController(final Gson gson) {
    this.gson = gson;
  }

  /**
   * The Subscription service.
   */
  @Autowired
  private SubscriptionService subscriptionService;

  /**
   * The User subscription service.
   */
  @Autowired
  private UserSubscriptionService userSubscriptionService;

  @Autowired
  private ScheduledTasks scheduledTasks;


  /**
   * Gets all subscription.
   *
   * @return the all subscription
   */
  @GetMapping(path = "/getAll")
  public ResponseEntity<List<SubscriptionBo>> getAllSubscription() {
    try {
      return ResponseEntity.ok(subscriptionService.getAllSubscriptions());
    } catch (Exception e) {
      return new ResponseEntity("Couldn't Fetch Details,", HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Search based on name response entity.
   *
   * @param name the name
   * @return the response entity
   */
  @GetMapping(path = "/name/{name}")
  public ResponseEntity<?> searchBasedOnName(@PathVariable("name") String name) {
    return new ResponseEntity<>(subscriptionService.searchSubscriptionsBasedOnName(name),
      HttpStatus.OK);
  }

  /**
   * Search based on category response entity.
   *
   * @param category the category
   * @return the response entity
   */
  @GetMapping(path = "category/{category}")
  public ResponseEntity<List<SubscriptionBo>> searchBasedOnCategory(
    @PathVariable("category") String category) {
    return ResponseEntity.ok(subscriptionService.searchSubscriptionsBasedOnCategory(category));
  }

  /**
   * Add subscription response entity.
   *
   * @param subscriptionDTO the subscription dto
   * @return the response entity
   */
  @PostMapping(path = "/add")
  public ResponseEntity<?> addSubscription(@RequestBody SubscriptionDto subscriptionDTO) {

    try {
      SubscriptionBo subscriptionBO = modelMapper.map(subscriptionDTO, SubscriptionBo.class);
      subscriptionService.addSubscription(subscriptionBO);
      return ResponseEntity.ok("Sucessfully added a subscription");
    } catch (Exception e) {
      return new ResponseEntity<>("Couldn't add the Subscription", HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Send newsletter response entity.
   *
   * @param newsLetterDTO the news letter dto
   * @return the response entity
   * gson
   */
  @RequestMapping(path = "/sendNewsletters")
  public ResponseEntity<?> sendNewsletter(@RequestBody NewsLetterDto newsLetterDTO) {
    scheduledTasks.scheduleTaskWithCronExpression();
    producer.sendMessage (
      Constants.TOPIC_PATTERN + newsLetterDTO.getCategory(), gson.toJson(newsLetterDTO));
    return ResponseEntity.ok("Mail Sent Sucessfully");

  }
}
