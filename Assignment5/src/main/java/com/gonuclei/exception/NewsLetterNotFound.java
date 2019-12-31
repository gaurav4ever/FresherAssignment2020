package com.gonuclei.exception;

public class NewsLetterNotFound extends Exception {

    public NewsLetterNotFound() {
        System.out.println("Subscription not found");
    }

    public NewsLetterNotFound(String message) {
        super(message);
    }
}
