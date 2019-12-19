package com.gonuclei.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Db not modified exception.
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,
  reason = "Subscription could not be modified in database")
public class DbNotModifiedException extends RuntimeException {

  /**
   * The Message.
   */
  private String message;
  /**
   * The Http status.
   */
  private HttpStatus httpStatus;

  /**
   * Instantiates a new Db not modified exception.
   */
  public DbNotModifiedException() {

  }

  /**
   * Instantiates a new Db not modified exception.
   *
   * @param message the message
   */
  public DbNotModifiedException(String message) {
    this.message = message;
  }

  /**
   * Instantiates a new Db not modified exception.
   *
   * @param message1   the message 1
   * @param httpStatus the http status
   */
  public DbNotModifiedException(String message1, HttpStatus httpStatus) {
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
