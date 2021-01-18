package com.gonuclei.bo;

/**
 * The type News letter bo.
 */
public class NewsLetterBo {

  /**
   * The Category.
   */
  private String category;
  /**
   * The Message.
   */
  private String message;

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

  public NewsLetterBo(final String category, final String message) {
    this.category = category;
    this.message = message;
  }
}
