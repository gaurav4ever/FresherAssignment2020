package com.gonuclei.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Abstract user model.
 */
@MappedSuperclass
public abstract class AbstractUserModel implements Serializable {

  /**
   * The Id.
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * The Email id.
   */
  @Column(name = "email_id")
  private String emailId;

  /**
   * The Name.
   */
  @Column(name = "name")
  private String name;

  /**
   * The Mobile.
   */
  @Column(name = "mobile")
  private String mobile;

  /**
   * The Password.
   */
  @Column(name = "password")
  private String password;

  /**
   * Instantiates a new Abstract user model.
   */
  public AbstractUserModel() {
  }

  /**
   * Instantiates a new Abstract user model.
   *
   * @param emailId  the email id
   * @param name     the name
   * @param mobile   the mobile
   * @param password the password
   * @param id       the id
   */
  public AbstractUserModel(String emailId, String name, String mobile, String password, Long id) {
    this.id = id;
    this.emailId = emailId;
    this.name = name;
    this.mobile = mobile;
    this.password = password;
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
   * Gets email id.
   *
   * @return the email id
   */
  public String getEmailId() {
    return emailId;
  }

  /**
   * Sets email id.
   *
   * @param emailId the email id
   */
  public void setEmailId(final String emailId) {
    this.emailId = emailId;
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
   * Gets mobile.
   *
   * @return the mobile
   */
  public String getMobile() {
    return mobile;
  }

  /**
   * Sets mobile.
   *
   * @param mobile the mobile
   */
  public void setMobile(final String mobile) {
    this.mobile = mobile;
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
}
