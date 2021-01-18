package com.gonuclei.models.dto;

/**
 * The type Authentication request.
 */
public class AuthenticationRequest {

  /**
   * The Username.
   */
  private String username;
  /**
   * The Password.
   */
  private String password;

  /**
   * Instantiates a new Authentication request.
   */
  public AuthenticationRequest() {
  }

  /**
   * Instantiates a new Authentication request.
   *
   * @param username the username
   * @param password the password
   */
  public AuthenticationRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }

  /**
   * Gets username.
   *
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets username.
   *
   * @param username the username
   */
  public void setUsername(final String username) {
    this.username = username;
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
