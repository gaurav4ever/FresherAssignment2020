package com.gonuclei.exception;

/**
 * The type News letter not found.
 */
public class NewsLetterNotFound extends Exception {

    /**
     * Instantiates a new News letter not found.
     */
    public NewsLetterNotFound() {
        System.out.println("Subscription not found");
    }

    /**
     * Instantiates a new News letter not found.
     *
     * @param message the message
     */
    public NewsLetterNotFound(String message) {
        super(message);
    }
}
