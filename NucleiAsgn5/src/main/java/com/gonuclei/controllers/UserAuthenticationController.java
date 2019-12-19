package com.gonuclei.controllers;

import com.gonuclei.models.dto.AuthenticationRequest;
import com.gonuclei.models.dto.AuthenticationResponse;
import com.gonuclei.models.dto.SignupRequest;
import com.gonuclei.security.JwtUtil;
import com.gonuclei.services.UserService;
import com.gonuclei.mapper.UserObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User authentication controller.
 */
@RestController
class UserAuthenticationController {

  /**
   * The User service.
   */
  @Autowired
  private UserService userService;

  /**
   * The Jwt util.
   */
  @Autowired
  private JwtUtil jwtUtil;

  /**
   * The User object mapper.
   */
  @Autowired
  private UserObjectMapper userObjectMapper;

  /**
   * Crete authentication token response entity.
   *
   * @param authenticationRequest the authentication request
   * @return the response entity
   */
  @PostMapping(path = "/authenticate")
  private ResponseEntity<?> creteAuthenticationToken(
    @RequestBody AuthenticationRequest authenticationRequest) {
    final String jwt = userService
      .login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }

  /**
   * Signup response entity.
   *
   * @param user the user
   * @return the response entity
   * @throws Exception the exception
   */
  @PostMapping(path = "/signup")
  public ResponseEntity<?> signup(@RequestBody SignupRequest user) throws Exception {
    return ResponseEntity.ok(userService.signup(userObjectMapper.userRequestToUserBo(user)));
  }
}
