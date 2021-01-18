package com.gonuclei.repository;

import com.gonuclei.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Slave user repository.
 */
public interface SlaveUserRepository extends CrudRepository<UserEntity, Long> {



  /**
   * Find by id containing list.
   *
   * @param id the name
   * @return user entity
   */
  Optional<UserEntity> findById(Long id);

  /**
   * Find by name containing list.
   *
   * @param name the name
   * @return the list
   */
  List<UserEntity> findByNameContaining(String name);

  /**
   * Return all subscription entity.
   *
   * @return the list
   */
  List<UserEntity> findAll();

}
