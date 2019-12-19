package com.gonuclei.models.dto;

import org.springframework.stereotype.Component;

/**
 * The type Email dto.
 */
@Component
public class EmailDto {

  /**
   * The Message.
   */
  private String message;
  /**
   * The Category.
   */
  private String category;

  /**
   * Instantiates a new Email dto.
   *
   * @param message  the message
   * @param category the category
   */
  public EmailDto(String message, String category) {
    this.message = message;
    this.category = category;
  }

  /**
   * Instantiates a new Email dto.
   */
  public EmailDto() {
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
