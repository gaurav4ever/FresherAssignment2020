package com.gonuclei.repository;

import com.gonuclei.entities.SubscriptionEntity;
import com.gonuclei.enums.SubscriptionStatusEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Slave subscription repository.
 */
public interface SlaveSubscriptionRepository extends CrudRepository<SubscriptionEntity, Long> {

  List<SubscriptionEntity> findAllBySubscriptionState(SubscriptionStatusEnum subscriptionStatus);
}
