package com.gonuclei.controllers;

import com.gonuclei.bo.UserBo;
import com.gonuclei.dto.JwtToken;
import com.gonuclei.dto.UserAuthenticationDto;
import com.gonuclei.dto.UserDto;
import com.gonuclei.exceptions.CustomException;
import com.gonuclei.exceptions.UnauthorizedException;
import com.gonuclei.kafka.MyProducer;
import com.gonuclei.services.UserService;
import com.gonuclei.services.UserSubscriptionService;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/users")
public class UserController {

  /**
   * The User service.
   */
  @Autowired
  private UserService userService;

  /**
   * The User subscription service.
   */
  @Autowired
  private UserSubscriptionService userSubscriptionService;

  /**
   * The Producer.
   */
  @Autowired
  private MyProducer producer;

  /**
   * The Model mapper.
   */
  private ModelMapper modelMapper = new ModelMapper();

  /**
   * The My topic.
   */
  private String myTopic;


  /**
   * Gets all users.
   *
   * @return the all users
   */
  @GetMapping("/getAllUsers")
  List<UserBo> getAllUsers() {

    producer.sendMessage("test", "dev");

    return userService.getAllUsers();
  }

  /**
   * Create authentication token response entity.
   *
   * @param authenticationRequest the authentication request
   * @return the response entity
   * @throws Exception the exception
   */
  @RequestMapping(path = "/login", method = RequestMethod.POST)
  private ResponseEntity<?> createAuthenticationToken(
    @RequestBody UserAuthenticationDto authenticationRequest) {
    try {
      return ResponseEntity.ok(new JwtToken(userService.login(authenticationRequest)));
    } catch (UnauthorizedException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Gets user by email.
   *
   * @param email the email
   * @return the user by email
   */
  @RequestMapping("/{email}")
  UserBo getUserByEmail(@PathVariable("email") String email) {
    return userService.getUserByEmail(email);
  }

  /**
   * Create authentication token response entity.
   *
   * @param userDTO the user dto
   * @return the response entity
   */
  @RequestMapping("/signup")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDto userDTO) {
    final String jwt = userService.signup(modelMapper.map(userDTO, UserBo.class));
    return ResponseEntity.ok(new JwtToken(jwt));
  }

  /**
   * Gets user subscriptions.
   *
   * @param request the request
   * @return the user subscriptions
   */
  @RequestMapping("/getMySubscriptions")
  public ResponseEntity<?> getUserSubscriptions(HttpServletRequest request) {
    return new ResponseEntity<>(userSubscriptionService.getUserSubscriptions(request),
      HttpStatus.OK);
  }

  /**
   * Add my subscription response entity.
   *
   * @param id      the id
   * @param request the request
   * @return the response entity
   */
  @RequestMapping("/addMySubscription/{id}")
  public ResponseEntity<?> addMySubscription(@PathVariable("id") Long id,
    HttpServletRequest request) {
    try {
      return new ResponseEntity<>(userSubscriptionService.buySubscription(id, request),
        HttpStatus.OK);
    } catch (CustomException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
  }

  /**
   * Remove my subscription response entity.
   *
   * @param id      the id
   * @param request the request
   * @return the response entity
   */
  @RequestMapping("/removeMySubscription/{id}")
  public ResponseEntity<?> removeMySubscription(@PathVariable("id") Long id,
    HttpServletRequest request) {
    try {
      return new ResponseEntity<>(userSubscriptionService.deleteSubscription(id, request),
        HttpStatus.OK);
    } catch (CustomException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
  }

  /**
   * Renew my subscription response entity.
   *
   * @param id      the id
   * @param request the request
   * @return the response entity
   */
  @RequestMapping("/renewMySubscription/{id}")
  public ResponseEntity<?> renewMySubscription(@PathVariable("id") Long id,
    HttpServletRequest request) {
    try {
      return new ResponseEntity<>(userSubscriptionService.renewSubscription(id, request),
        HttpStatus.OK);
    } catch (CustomException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
  }


}
