package com.gonuclei.services;

import com.gonuclei.bo.UserBo;
import com.gonuclei.dto.UserAuthenticationDto;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * The interface User service.
 */
@Component
public interface UserService {

  /**
   * Login string.
   *
   * @param userAuthenticationDto the user authentication
   * @return the string
   */
  String login(UserAuthenticationDto userAuthenticationDto);

  /**
   * Gets all users.
   *
   * @return the all users
   */
  List<UserBo> getAllUsers();

  /**
   * Gets user by email.
   *
   * @param email the email
   * @return the user by email
   */
  UserBo getUserByEmail(String email);

  /**
   * Signup string.
   *
   * @param user the user
   * @return the string
   */
  String signup(UserBo user);

}
