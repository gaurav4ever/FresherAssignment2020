package com.gonuclei.repositories;

import com.bizdirect.data.annotations.SlaveRepository;
import com.gonuclei.entities.UserEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The interface Slave user repository.
 */
@SlaveRepository
public interface SlaveUserRepository extends JpaRepository<UserEntity, Long> {

  /**
   * Find by email optional.
   *
   * @param email the email
   * @return the optional
   */
  Optional<UserEntity> findByEmail(String email);

  /**
   * Exists by email boolean.
   *
   * @param email the email
   * @return the boolean
   */
  boolean existsByEmail(String email);
}
