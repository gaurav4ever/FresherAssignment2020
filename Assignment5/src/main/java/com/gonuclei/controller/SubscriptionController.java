package com.gonuclei.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {

    @PostMapping("/subscribe/user/{userId}/subscription/{subscriptionId}")
    public void subscribe(@PathVariable Integer userId, @PathVariable Integer subscriptionId) {
        //TODO: Implement subscription logic and call and add request body
    }
}
