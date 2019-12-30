package com.gonuclei.models.bo;

import java.util.Date;

/**
 * The type Subscription bo.
 */
public class SubscriptionBo {

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
  private Double price;
  /**
   * The Validity.
   */
  private int validity;
  /**
   * The Created on.
   */
  private Date createdOn;
  /**
   * The Created by.
   */
  private String createdBy;
  /**
   * The Modified on.
   */
  private Date modifiedOn;
  /**
   * The Modified by.
   */
  private String modifiedBy;

  /**
   * Instantiates a new Subscription bo.
   */
  public SubscriptionBo() {
  }

  /**
   * Instantiates a new Subscription bo.
   *
   * @param id         the id
   * @param name       the name
   * @param category   the category
   * @param price      the price
   * @param validity   the validity
   * @param createdOn  the created on
   * @param createdBy  the created by
   * @param modifiedOn the modified on
   * @param modifiedBy the modified by
   */
  public SubscriptionBo(Long id, String name, String category, Double price, int validity,
                        Date createdOn, String createdBy, Date modifiedOn, String modifiedBy) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.price = price;
    this.validity = validity;
    this.createdOn = createdOn;
    this.createdBy = createdBy;
    this.modifiedOn = modifiedOn;
    this.modifiedBy = modifiedBy;
  }

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
  public void setId(final Long id) {
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
  public void setName(final String name) {
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
  public void setCategory(final String category) {
    this.category = category;
  }

  /**
   * Gets price.
   *
   * @return the price
   */
  public Double getPrice() {
    return price;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(final Double price) {
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
  public void setValidity(final int validity) {
    this.validity = validity;
  }

  /**
   * Gets created on.
   *
   * @return the created on
   */
  public Date getCreatedOn() {
    return createdOn;
  }

  /**
   * Sets created on.
   *
   * @param createdOn the created on
   */
  public void setCreatedOn(final Date createdOn) {
    this.createdOn = createdOn;
  }

  /**
   * Gets created by.
   *
   * @return the created by
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Sets created by.
   *
   * @param createdBy the created by
   */
  public void setCreatedBy(final String createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * Gets modified on.
   *
   * @return the modified on
   */
  public Date getModifiedOn() {
    return modifiedOn;
  }

  /**
   * Sets modified on.
   *
   * @param modifiedOn the modified on
   */
  public void setModifiedOn(final Date modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  /**
   * Gets modified by.
   *
   * @return the modified by
   */
  public String getModifiedBy() {
    return modifiedBy;
  }

  /**
   * Sets modified by.
   *
   * @param modifiedBy the modified by
   */
  public void setModifiedBy(final String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }
}
