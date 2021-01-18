package com.gonuclei.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The type Abstract user.
 */
@MappedSuperclass
public abstract class AbstractUser {

  /**
   * The Id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  /**
   * The Email.
   */
  @Column(name = "email")
  private String email;

  /**
   * The Password.
   */
  @Column(name = "password")
  private String password;

  /**
   * The Mobile number.
   */
  @Column(name = "mobile")
  private String mobileNumber;

  /**
   * The Name.
   */
  @Column(name = "name")
  private String name;

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
  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * Gets password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets password.
   *
   * @param password the password
   */
  public void setPassword(final String password) {
    this.password = password;
  }

  /**
   * Gets mobile number.
   *
   * @return the mobile number
   */
  public String getMobileNumber() {
    return mobileNumber;
  }

  /**
   * Sets mobile number.
   *
   * @param mobileNumber the mobile number
   */
  public void setMobileNumber(final String mobileNumber) {
    this.mobileNumber = mobileNumber;
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
}
