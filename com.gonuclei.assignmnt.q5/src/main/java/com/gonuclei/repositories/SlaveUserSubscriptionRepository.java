package com.gonuclei.repositories;

import com.bizdirect.data.annotations.SlaveRepository;
import com.gonuclei.entities.UserSubscriptionEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Slave user subscription repository.
 */
@SlaveRepository
public interface SlaveUserSubscriptionRepository extends
  JpaRepository<UserSubscriptionEntity, Long> {

  /**
   * Find by email list.
   *
   * @param email the email
   * @return the list
   */
  List<UserSubscriptionEntity> findByEmail(String email);

  /**
   * Find by email and subscription id optional.
   *
   * @param email          the email
   * @param subscriptionId the subscription id
   * @return the optional
   */
  Optional<UserSubscriptionEntity> findByEmailAndSubscriptionId(String email, Long subscriptionId);

  /**
   * Find by subscription category list.
   *
   * @param category the category
   * @return the list
   */
  List<UserSubscriptionEntity> findBySubscriptionCategoryAndStatus(String category, int status);

  List<UserSubscriptionEntity> findByStatus(int status);

}
