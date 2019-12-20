package com.gonuclei.repositories;

import com.bizdirect.data.annotations.MasterRepository;
import com.gonuclei.entities.UserSubscriptionEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Master user subscription repository.
 */
@MasterRepository
public interface MasterUserSubscriptionRepository extends
  JpaRepository<UserSubscriptionEntity, Long> {

}
