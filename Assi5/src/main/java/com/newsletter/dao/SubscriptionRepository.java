package com.newsletter.dao;

import com.newsletter.entities.SubscriptionEntity;
import com.newsletter.models.SubscriptionModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

  List<SubscriptionEntity> findByEmail(String email);
}
