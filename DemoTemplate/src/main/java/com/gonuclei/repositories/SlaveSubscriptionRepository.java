package com.gonuclei.repositories;

import com.bizdirect.data.annotations.SlaveRepository;
import com.gonuclei.entities.SubscriptionEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Slave subscription repository.
 */
@SlaveRepository
public interface SlaveSubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

  /**
   * Find by category list.
   *
   * @param category the category
   * @return the list
   */
  List<SubscriptionEntity> findByCategory(String category);

  /**
   * Find by name containing list.
   *
   * @param name the name
   * @return the list
   */
  List<SubscriptionEntity> findByNameContaining(String name);

}
