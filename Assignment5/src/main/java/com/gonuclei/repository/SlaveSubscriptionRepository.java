package com.gonuclei.repository;

import com.gonuclei.entities.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Slave subscription repository.
 */
public interface SlaveSubscriptionRepository extends CrudRepository<SubscriptionEntity, Long> {
}
