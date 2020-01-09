package com.gonuclei.exception;

import org.springframework.http.HttpStatus;

/**
 * The type Bad request exception.
 */
public class BadRequestException extends RuntimeException {

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
   * Instantiates a new Bad request exception.
   *
   * @param message    the message
   * @param httpStatus the http status
   */
  public BadRequestException(final String message, HttpStatus httpStatus) {
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
