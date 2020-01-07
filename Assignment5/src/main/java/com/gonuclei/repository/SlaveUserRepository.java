package com.gonuclei.repository;

import com.gonuclei.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SlaveUserRepository extends CrudRepository<UserEntity, Integer> {

  /**
   * Find by id user entity.
   *
   * @param id the id
   * @return the user entity
   */
  UserEntity findById(Long id);

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
