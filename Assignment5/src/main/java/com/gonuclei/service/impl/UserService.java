package com.gonuclei.service.impl;

import com.gonuclei.dto.UserDto;
import com.gonuclei.exception.UserNotFoundException;
import com.gonuclei.service.transactions.UserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type User service.
 */
@Service
public class UserService {

  private final UserTransactionService userTransactionService;

  /**
   * Instantiates a new User service.
   *
   * @param userTransactionService the user transaction service
   */
  @Autowired
  public UserService(UserTransactionService userTransactionService) {
    this.userTransactionService = userTransactionService;
  }

  /**
   * Gets users.
   *
   * @return the users
   */
  public List<UserDto> getUsers() {
    return userTransactionService.getAllUsers();
  }

  /**
   * Gets user.
   *
   * @param id the id
   * @return the user
   * @throws UserNotFoundException the user not found exception
   */
  public UserDto getUser(Long id) throws UserNotFoundException {

    return userTransactionService.getUser(id);
  }

  /**
   * Add user.
   *
   * @param user the user
   */
  public void addUser(UserDto user){

    userTransactionService.addUser(user);
  }

  /**
   * Modify user.
   *
   * @param user the user
   */
  public void modifyUser(UserDto user) {

    //TODO: Modify this method for proper implementation
    userTransactionService.addUser(user);
  }
}
