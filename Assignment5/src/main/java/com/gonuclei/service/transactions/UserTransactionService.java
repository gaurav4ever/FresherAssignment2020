package com.gonuclei.service.transactions;

import com.gonuclei.dto.UserDto;
import com.gonuclei.entities.UserEntity;
import com.gonuclei.exception.BadRequestException;
import com.gonuclei.exception.UserNotFoundException;
import com.gonuclei.repository.MasterUserRepository;
import com.gonuclei.repository.SlaveUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type User transaction service.
 */
@Service
public class UserTransactionService {

  private final ModelMapper modelMapper;
  private final SlaveUserRepository slaveUserRepository;
  private final MasterUserRepository masterUserRepository;

  /**
   * Instantiates a new User transaction service.
   *
   * @param slaveUserRepository  the slave user repository
   * @param masterUserRepository the master user repository
   */
  @Autowired
  public UserTransactionService(SlaveUserRepository slaveUserRepository, MasterUserRepository masterUserRepository) {
    this.slaveUserRepository = slaveUserRepository;
    this.masterUserRepository = masterUserRepository;
    this.modelMapper = new ModelMapper();
  }

  /**
   * Gets all users.
   *
   * @return the all users
   */
  public List<UserDto> getAllUsers() {
    return Optional.of(slaveUserRepository.findAll()
        .stream()
        .map(userEntity -> modelMapper.map(userEntity, UserDto.class))
        .collect(Collectors.toList())
    ).orElse(new ArrayList<>());
  }

  /**
   * Gets user.
   *
   * @param id the id
   * @return the user
   * @throws UserNotFoundException the user not found exception
   */
  public UserDto getUser(Long id) throws UserNotFoundException {

    final UserEntity obtainedUser = slaveUserRepository.findById(id).orElseThrow(UserNotFoundException::new);
    return modelMapper.map(obtainedUser, UserDto.class);
  }


  /**
   * Add user.
   *
   * @param userDto the user dto
   */
  public void addUser(UserDto userDto) {

    try {
      masterUserRepository.save(modelMapper.map(userDto, UserEntity.class));
    } catch (RuntimeException e) {
      throw new BadRequestException("Subscription Could not be added", HttpStatus.BAD_REQUEST);
    }
  }
}
