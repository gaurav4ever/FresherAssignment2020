package com.gonuclei.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Subscription not found exception.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Subscriptions not found in the database")
public class SubscriptionNotFoundException extends RuntimeException {

  /**
   * The Message.
   */
  private String message;
  /**
   * The Http status.
   */
  private HttpStatus httpStatus;

  /**
   * Instantiates a new Subscription not found exception.
   */
  public SubscriptionNotFoundException() {

  }

  /**
   * Instantiates a new Subscription not found exception.
   *
   * @param message the message
   */
  public SubscriptionNotFoundException(String message) {
    this.message = message;
  }

  /**
   * Instantiates a new Subscription not found exception.
   *
   * @param message1   the message 1
   * @param httpStatus the http status
   */
  public SubscriptionNotFoundException(String message1, HttpStatus httpStatus) {
    this.message = message1;
    this.httpStatus = httpStatus;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  @Override
  public String getMessage() {
    return message;
  }

  /**
   * Gets http status.
   *
   * @return the http status
   */
  public HttpStatus getHttpStatus() {
    return httpStatus;
  }
}
