package com.gonuclei.exceptions;

import org.springframework.http.HttpStatus;

/**
 * The type Internal server exception.
 */
public class InternalServerException extends RuntimeException {

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
   * Instantiates a new Internal server exception.
   *
   * @param message    the message
   * @param httpStatus the http status
   */
  public InternalServerException(String message, HttpStatus httpStatus) {
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
