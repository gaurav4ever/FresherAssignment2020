package com.gonuclei.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type User not found exception.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This user is not found in the database")
public class UserNotFoundException extends RuntimeException {

  /**
   * The Message.
   */
  private String message;
  /**
   * The Http status.
   */
  private HttpStatus httpStatus;


  /**
   * Instantiates a new User not found exception.
   */
  public UserNotFoundException() {

  }

  /**
   * Instantiates a new User not found exception.
   *
   * @param message the message
   */
  public UserNotFoundException(String message) {
    this.message = message;
  }

  /**
   * Instantiates a new User not found exception.
   *
   * @param message    the message
   * @param httpStatus the http status
   */
  public UserNotFoundException(String message, HttpStatus httpStatus) {
    this.message = message;
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
