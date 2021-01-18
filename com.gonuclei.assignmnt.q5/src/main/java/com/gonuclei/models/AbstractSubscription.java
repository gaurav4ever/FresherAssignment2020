package com.gonuclei.models;


import com.bizdirect.data.Auditable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The type Abstract subscription.
 */
@MappedSuperclass
public abstract class AbstractSubscription {

  /**
   * The Id.
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * The Name.
   */
  @Column(name = "name")
  private String name;

  /**
   * The Category.
   */
  @Column(name = "category")
  private String category;

  /**
   * The Price.
   */
  @Column(name = "price")
  private double price;

  /**
   * The Validity.
   */
  @Column(name = "validity")
  private int validity;

  /**
   * The Created by.
   */
  @Column(name = "created_by")
  private String createdBy;

  /**
   * The Created on.
   */
  @Column(name = "created_on")
  private Date createdOn;

  /**
   * The Modified on.
   */
  @Column(name = "modified_on")
  private Date modifiedOn;

  /**
   * The Modified by.
   */
  @Column(name = "modified_by")
  private String modifiedBy;

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
  public double getPrice() {
    return price;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(final double price) {
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
