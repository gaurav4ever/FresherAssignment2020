package com.gonuclei.controller;

import com.gonuclei.model.AbstractSubscriptionModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {

    @PostMapping("/subscribe/user/{userId}/subscription/{subscriptionId}")
    public void subscribe(@PathVariable Integer userId, @PathVariable Integer subscriptionId, @RequestBody AbstractSubscriptionModel subscription) {
        //TODO: Implement subscription logic and call and add request body
    }
}
