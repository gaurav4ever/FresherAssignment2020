package com.gonuclei.dto;

/**
 * The type User authentication.
 */
public class UserAuthenticationDto {

  /**
   * The Username.
   */
  private String username;
  /**
   * The Password.
   */
  private String password;

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
   * @param email the email
   */
  public void setUsername(String email) {
    this.username = email;
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
  public void setPassword(String password) {
    this.password = password;
  }
}
