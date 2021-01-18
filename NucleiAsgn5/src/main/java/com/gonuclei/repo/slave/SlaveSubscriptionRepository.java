package com.gonuclei.repo.slave;

import com.bizdirect.data.annotations.SlaveRepository;
import com.gonuclei.models.entities.SubscriptionEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Slave subscription repository.
 */
@SlaveRepository
public interface SlaveSubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

  /**
   * Find all list.
   *
   * @return the list
   */
  List<SubscriptionEntity> findAll();

  /**
   * Find by category list.
   *
   * @param category the category
   * @return the list
   */
  List<SubscriptionEntity> findByCategory(String category);

  /**
   * Find by name subscription entity.
   *
   * @param name the name
   * @return the subscription entity
   */
  SubscriptionEntity findByName(String name);

  /**
   * Find by id optional.
   *
   * @param id the id
   * @return the optional
   */
  Optional<SubscriptionEntity> findById(Long id);
}
