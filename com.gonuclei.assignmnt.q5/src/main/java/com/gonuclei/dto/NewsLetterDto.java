package com.gonuclei.dto;

/**
 * The type News letter dto.
 */
public class NewsLetterDto {

  /**
   * The Category.
   */
  private String category;
  /**
   * The Message.
   */
  private String message;

  /**
   * Instantiates a new News letter dto.
   */
  public NewsLetterDto() {
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
  public void setCategory(String category) {
    this.category = category;
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
  public void setMessage(String message) {
    this.message = message;
  }
}
