package com.gonuclei.services.impl;

import com.gonuclei.bo.UserBo;
import com.gonuclei.dto.UserAuthenticationDto;
import com.gonuclei.exceptions.CustomException;
import com.gonuclei.exceptions.UnauthorizedException;
import com.gonuclei.security.JwtUtil;
import com.gonuclei.services.UserService;
import com.gonuclei.transactionServices.UserTransactionalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

  /**
   * The User transactional service.
   */
  @Autowired
  private UserTransactionalService userTransactionalService;

  /**
   * The Jwt util.
   */
  @Autowired
  private JwtUtil jwtUtil;

  /**
   * The Authentication manager.
   */
  @Autowired
  private AuthenticationManager authenticationManager;

  /**
   * The Password encoder.
   */
  @Autowired
  private PasswordEncoder passwordEncoder;

  /**
   * Login string.
   *
   * @param userAuthenticationDto the user authentication
   * @return the string
   */
  public String login(UserAuthenticationDto userAuthenticationDto) {

    try {
      authenticationManager.authenticate
        (new UsernamePasswordAuthenticationToken(userAuthenticationDto.getUsername(),
          userAuthenticationDto.getPassword()));
      return jwtUtil.generateToken(userAuthenticationDto.getUsername());
    } catch (Exception e) {
      throw new UnauthorizedException(" Invalid username/password supplied",
        HttpStatus.UNAUTHORIZED);
    }

//    Optional<UserEntity> user = null;
//    user =  userRepository.findByEmail(userAuthentication.getEmail());
//    if(user.isEmpty()){
//      throw new CustomException("User Does not exists", HttpStatus.UNPROCESSABLE_ENTITY);
//    }
//    if(userAuthentication.getPassword().contentEquals(user.get().getPassword())) {
//      return jwtTokenProvider.createToken(userAuthentication.getEmail());
//    }
//     throw new CustomException("Email and user does not match", HttpStatus.UNPROCESSABLE_ENTITY);
  }

  /**
   * Gets all users.
   *
   * @return the all users
   */
  @Override
  public List<UserBo> getAllUsers() {
    return userTransactionalService.getAllUsers();
  }

  /**
   * Gets user by email.
   *
   * @param email the email
   * @return the user by email
   */
  @Override
  public UserBo getUserByEmail(String email) {
    return userTransactionalService.getUserByEmail(email);
  }

  /**
   * Signup string.
   *
   * @param user the user
   * @return the string
   */
  public String signup(UserBo user) {

    if (userTransactionalService.getUserByEmail(user.getEmail()).equals(null)) {
//      user.setPassword(passwordEncoder.encode(user.getPassword()));
      userTransactionalService.saveUser(user);
      return jwtUtil.generateToken(user.getEmail());
    } else {
      throw new CustomException("Provided email is already in use",
        HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

}
