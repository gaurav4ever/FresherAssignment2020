package com.gonuclei.models.dto;

/**
 * The type Message response.
 */
public class MessageResponse {

  /**
   * The Message.
   */
  String message;

  /**
   * Instantiates a new Message response.
   *
   * @param message the message
   */
  public MessageResponse(String message) {
    this.message = message;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets message.
   *
   * @param message the message
   */
  public void setMessage(final String message) {
    this.message = message;
  }
}
