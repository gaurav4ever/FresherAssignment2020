package com.gonuclei.models.bo;

import org.springframework.stereotype.Component;

/**
 * The type Email bo.
 */
@Component
public class EmailBo {

  /**
   * The Message.
   */
  private String message;
  /**
   * The Category.
   */
  private String category;

  /**
   * Instantiates a new Email bo.
   *
   * @param message  the message
   * @param category the category
   */
  public EmailBo(String message, String category) {
    this.message = message;
    this.category = category;
  }

  /**
   * Instantiates a new Email bo.
   */
  public EmailBo() {
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

  /**
   * Gets category.
   *
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Sets category.
   *
   * @param category the category
   */
  public void setCategory(final String category) {
    this.category = category;
  }
}
