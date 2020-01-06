package com.newsletter.controllers;

//import com.newsletter.entities.UserEntity;
import com.newsletter.models.User;
import com.newsletter.services.impl.UserService;
//import com.newsletter.services.impl.UserServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type User controller.
 */
@RestController
public class UserController {
  @Autowired
  private UserService service;

  /**
   * Add user.
   *
   * @param user the user
   */
  @RequestMapping(method = RequestMethod.POST, value = "/addUser")
  public void addUser(@RequestBody User user) {
    service.addUser(user);
  }

  /**
   * Gets all users.
   *
   * @return the all users
   */
  @RequestMapping("/getAllUsers")
  public List<User> getAllUsers() {
    return service.getAllUsers();
  }

  /**
   * Gets user.
   *
   * @param email the email
   * @return the user
   */
  @RequestMapping("getUser/{email}")
  public User getUser(@PathVariable String email) {
    return service.getUser(email);
  }

  /**
   * Remove user.
   *
   * @param email the email
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/removeUser/{email}")
  public void removeUser(@PathVariable String email) {
    service.removeUser(email);
  }



}