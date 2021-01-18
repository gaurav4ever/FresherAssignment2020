package com.gonuclei.services.impl;

import com.gonuclei.models.bo.UserBo;
import com.gonuclei.security.JwtUtil;
import com.gonuclei.services.UserService;
import com.gonuclei.transactionService.UserTransactionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

  /**
   * The Logger.
   */
  private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  /**
   * The Authentication manager.
   */
  @Autowired
  private AuthenticationManager authenticationManager;

  /**
   * The Jwt util.
   */
  @Autowired
  private JwtUtil jwtUtil;

  /**
   * The User transaction service.
   */
  @Autowired
  private UserTransactionService userTransactionService;

  /**
   * Login string.
   *
   * @param username the username
   * @param password the password
   * @return the string
   */
  @Override
  public String login(String username, String password) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
        password));

      return jwtUtil.generateToken(username);
    } catch (BadCredentialsException e) {
      logger.error("Incorrect user name password! " + e);
    }
    return null;
  }

  /**
   * Signup string.
   *
   * @param userBo the user bo
   * @return the string
   * @throws Exception the exception
   */
  @Override
  public String signup(UserBo userBo) throws Exception {
    if (userTransactionService.signupTransaction(userBo)) {
      return jwtUtil.generateToken(userBo.getEmailId());
    } else {
      throw new Exception("Username is already in use");
    }
  }
}
