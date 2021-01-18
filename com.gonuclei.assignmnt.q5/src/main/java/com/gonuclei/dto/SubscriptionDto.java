package com.gonuclei.dto;

/**
 * The type Subscription dto.
 */
public class SubscriptionDto {

  /**
   * The Id.
   */
  private Long id;
  /**
   * The Name.
   */
  private String name;
  /**
   * The Category.
   */
  private String category;
  /**
   * The Price.
   */
  private double price;
  /**
   * The Validity.
   */
  private int validity;

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
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
   * Gets price.
   *
   * @return the price
   */
  public double getPrice() {
    return price;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * Gets validity.
   *
   * @return the validity
   */
  public int getValidity() {
    return validity;
  }

  /**
   * Sets validity.
   *
   * @param validity the validity
   */
  public void setValidity(int validity) {
    this.validity = validity;
  }
}
