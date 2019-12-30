package com.gonuclei.repo.slave;

import com.bizdirect.data.annotations.SlaveRepository;
import com.gonuclei.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Slave user repository Used only for reading data purposes.
 */
@SlaveRepository
public interface SlaveUserRepository extends JpaRepository<UserEntity, Long> {

  /**
   * Find by email id optional.
   *
   * @param emailId the email id
   * @return the optional
   */
  Optional<UserEntity> findByEmailId(String emailId);

  /**
   * Exists by email id boolean.
   *
   * @param emailId the email id
   * @return the boolean
   */
  boolean existsByEmailId(String emailId);
}
