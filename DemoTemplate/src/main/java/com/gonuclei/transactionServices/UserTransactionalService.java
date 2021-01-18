package com.gonuclei.transactionServices;

import com.gonuclei.bo.UserBo;
import com.gonuclei.entities.UserEntity;
import com.gonuclei.exceptions.InternalServerException;
import com.gonuclei.repositories.MasterUserRepository;
import com.gonuclei.repositories.SlaveUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * The type User transactional service.
 */
@Component
public class UserTransactionalService {

  /**
   * The Model mapper.
   */
  ModelMapper modelMapper = new ModelMapper();
  /**
   * The Slave user repository.
   */
  @Autowired
  private SlaveUserRepository slaveUserRepository;
  /**
   * The Master user repository.
   */
  @Autowired
  private MasterUserRepository masterUserRepository;

  /**
   * Gets all users.
   *
   * @return the all users
   */
  public List<UserBo> getAllUsers() {
    try {
      return Optional.of(slaveUserRepository.findAll()
        .stream()
        .map(userEntity -> modelMapper.map(userEntity, UserBo.class))
        .collect(Collectors.toList())
      ).orElse(new ArrayList<>());
    } catch (Exception e) {
      throw new InternalServerException("couldn't get all users", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  /**
   * Gets user by email.
   *
   * @param email the email
   * @return the user by email
   */
  public UserBo getUserByEmail(String email) {
    try {
      return Optional.of(
        modelMapper.map(slaveUserRepository.findByEmail(email).get(), UserBo.class)
      ).orElse(null);
    } catch (Exception e) {
      throw new InternalServerException("Couldn't fetch user", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * Save user.
   *
   * @param user the user
   */
  public void saveUser(UserBo user) {
    try {
      masterUserRepository.save(modelMapper.map(user, UserEntity.class));
    } catch (RuntimeException e) {
      throw new InternalServerException("Sign Up Successful", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
