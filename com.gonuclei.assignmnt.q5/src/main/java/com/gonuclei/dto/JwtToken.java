package com.gonuclei.dto;

/**
 * The type Jwt token.
 */
public class JwtToken {

  /**
   * The Token.
   */
  String token;

  /**
   * Instantiates a new Jwt token.
   *
   * @param token the token
   */
  public JwtToken(String token) {
    this.token = token;
  }

  /**
   * Gets token.
   *
   * @return the token
   */
  public String getToken() {
    return token;
  }

  /**
   * Sets token.
   *
   * @param token the token
   */
  public void setToken(String token) {
    this.token = token;
  }
}
