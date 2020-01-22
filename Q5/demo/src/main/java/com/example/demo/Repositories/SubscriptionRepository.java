package com.example.demo.Repositories;

import com.example.demo.Model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
//    List<NewsLetter> findByTitleContaingOrContentContaining(String text, String textAgain);
}
