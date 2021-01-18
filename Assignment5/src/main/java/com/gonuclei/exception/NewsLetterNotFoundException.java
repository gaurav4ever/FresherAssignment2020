package com.gonuclei.exception;

/**
 * The type News letter not found.
 */
public class NewsLetterNotFoundException extends Exception {

  /**
   * Instantiates a new News letter not found.
   */
  public NewsLetterNotFoundException() {
    System.out.println("Subscription not found");
  }

  /**
   * Instantiates a new News letter not found.
   *
   * @param message the message
   */
  public NewsLetterNotFoundException(String message) {
    super(message);
  }
}
