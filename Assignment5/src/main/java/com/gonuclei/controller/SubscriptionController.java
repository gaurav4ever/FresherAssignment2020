package com.gonuclei.controller;

import com.gonuclei.dto.SubscriptionDto;
import com.gonuclei.service.impl.SubscriptionService;
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
        //TODO: Implement subscription logic and call and add request body
    }
}
