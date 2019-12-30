package com.gonuclei.repo.master;

import com.bizdirect.data.annotations.MasterRepository;
import com.gonuclei.models.AbstractUserSubscriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Master user subscription repository.
 */
@MasterRepository
public interface MasterUserSubscriptionRepository extends
  JpaRepository<AbstractUserSubscriptionModel, Long> {

}
