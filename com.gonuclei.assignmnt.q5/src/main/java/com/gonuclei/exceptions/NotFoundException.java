package com.gonuclei.exceptions;

import org.springframework.http.HttpStatus;

/**
 * The type Not found exception.
 */
public class NotFoundException extends RuntimeException {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The Message.
   */
  private final String message;
  /**
   * The Http status.
   */
  private final HttpStatus httpStatus;

  /**
   * Instantiates a new Not found exception.
   *
   * @param message    the message
   * @param httpStatus the http status
   */
  public NotFoundException(String message, HttpStatus httpStatus) {
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
