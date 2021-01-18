package com.gonuclei.repository;

import com.gonuclei.entities.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Master subscription repository.
 */
public interface MasterSubscriptionRepository extends CrudRepository<SubscriptionEntity, Long> {
}
