package com.gonuclei.exception;

/**
 * The type User not found exception.
 */
public class UserNotFoundException extends Exception {

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
    super(message);
  }
}
