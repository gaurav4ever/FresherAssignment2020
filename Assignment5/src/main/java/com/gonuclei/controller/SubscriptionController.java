package com.gonuclei.controller;

import com.gonuclei.dto.SubscriptionDto;
import com.gonuclei.exception.NewsLetterNotFoundException;
import com.gonuclei.exception.UserNotFoundException;
import com.gonuclei.service.impl.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Subscription controller.
 */
@RestController
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    /**
     * The constant LOGGER.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionController.class);

    /**
     * Instantiates a new Subscription controller.
     *
     * @param subscriptionService the subscription service
     */
    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    /**
     * Subscribe.
     *
     * @param subscription the subscription
     */
    @PostMapping("/subscribe")
    public void subscribe(@RequestBody SubscriptionDto subscription) {
        try {
            subscriptionService.addSubscription(subscription);
        } catch (UserNotFoundException e) {
            LOGGER.error("User not found");
        } catch (NewsLetterNotFoundException e) {
            LOGGER.error("News Letter not found");
        }
    }
}
