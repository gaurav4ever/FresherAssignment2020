package com.gonuclei.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The type Abstract user model.
 */
@MappedSuperclass
public abstract class AbstractUserModel implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name="address")
  private String address;

  @NotNull
  @Column(name = "email_address", unique=true, nullable = false)
  private String email;


  /**
   * Instantiates a new Abstract user model.
   */
  public AbstractUserModel() {
  }

  /**
   * Instantiates a new Abstract user model.
   *
   * @param id      the id
   * @param name    the name
   * @param address the address
   * @param email   the email
   */
  public AbstractUserModel(Long id, String name, String address, String email) {

    this.id = id;
    this.name = name;
    this.address = address;
    this.email = email;
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
   * Gets address.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets address.
   *
   * @param address the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email) {
    this.email = email;
  }
}
