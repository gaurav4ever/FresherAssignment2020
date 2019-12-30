package com.gonuclei.Assignment5.repository;

import com.gonuclei.Assignment5.entities.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;

public interface MasterSubscriptionRepository extends CrudRepository<SubscriptionEntity, Integer> {

}
