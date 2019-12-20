package com.gonuclei.Assignment5.exception;

public class SubscriptionNotFound extends Exception {

    public SubscriptionNotFound() {
        System.out.println("Subscription not found");
    }

    public SubscriptionNotFound(String message) {
        super(message);
    }
}
