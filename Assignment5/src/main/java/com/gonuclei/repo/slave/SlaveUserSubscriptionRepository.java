package com.gonuclei.repo.slave;

import com.bizdirect.data.annotations.SlaveRepository;
import com.gonuclei.models.entities.UserSubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Slave user subscription repository.
 */
@SlaveRepository
public interface SlaveUserSubscriptionRepository extends
  JpaRepository<UserSubscriptionEntity, Long> {

  /**
   * Find by email id list.
   *
   * @param emailId the email id
   * @return the list
   */
  List<UserSubscriptionEntity> findByEmailId(String emailId);

  /**
   * Find by subscription id list.
   *
   * @param subscriptionId the subscription id
   * @return the list
   */
  List<UserSubscriptionEntity> findBySubscriptionId(Long subscriptionId);

  /**
   * Find by email id and subscription id user subscription entity.
   *
   * @param emailId        the email id
   * @param subscriptionId the subscription id
   * @return the user subscription entity
   */
  UserSubscriptionEntity findByEmailIdAndSubscriptionId(String emailId, Long subscriptionId);

  /**
   * Find by subscription category list.
   *
   * @param category the category
   * @param status   the status
   * @return the list
   */
  List<UserSubscriptionEntity> findBySubscriptionCategoryAndStatus(String category, boolean status);

  /**
   * Find by status list.
   *
   * @param status the status
   * @return the list
   */
  List<UserSubscriptionEntity> findByStatus(boolean status);

}
