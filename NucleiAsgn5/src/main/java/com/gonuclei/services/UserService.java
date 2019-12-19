package com.gonuclei.services;

import com.gonuclei.models.bo.UserBo;

/**
 * The interface User service.
 */
public interface UserService {

  /**
   * Login string.
   *
   * @param username the username
   * @param password the password
   * @return the string
   */
  String login(String username, String password);

  /**
   * Signup string.
   *
   * @param userBo the user bo
   * @return the string
   * @throws Exception the exception
   */
  String signup(UserBo userBo) throws Exception;
}
