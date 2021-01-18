package com.gonuclei.security;


import com.gonuclei.entities.UserEntity;
import com.gonuclei.repositories.SlaveUserRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The type My user details service.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

  /**
   * The Slave user repository.
   */
  @Autowired
  private SlaveUserRepository slaveUserRepository;

  /**
   * Load user by username user details.
   *
   * @param username the username
   * @return the user details
   * @throws UsernameNotFoundException the username not found exception
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final Optional<UserEntity> user = slaveUserRepository.findByEmail(username);
    return new User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
  }
}
