package com.newsletter.newsletter.DTO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsletter.newsletter.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long>{

}
