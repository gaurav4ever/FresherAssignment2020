package com.gonuclei.repositories;

import com.bizdirect.data.annotations.MasterRepository;
import com.gonuclei.entities.SubscriptionEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Master subscription repository.
 */
@MasterRepository
public interface MasterSubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

}
