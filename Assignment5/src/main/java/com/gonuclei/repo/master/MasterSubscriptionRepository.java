package com.gonuclei.repo.master;

import com.bizdirect.data.annotations.MasterRepository;
import com.gonuclei.models.entities.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Master subscription repository.
 */
@MasterRepository
public interface MasterSubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

}

