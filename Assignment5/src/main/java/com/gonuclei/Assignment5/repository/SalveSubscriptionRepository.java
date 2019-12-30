package com.gonuclei.Assignment5.repository;

import com.gonuclei.Assignment5.entities.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalveSubscriptionRepository extends CrudRepository<SubscriptionEntity, Integer> {

    /**
     * Find by category list.
     *
     * @param category the category
     * @return the list
     */
    List<SubscriptionEntity> findByCategory(String category);

    /**
     * Find by name containing list.
     *
     * @param name the name
     * @return the list
     */
    List<SubscriptionEntity> findByNameContaining(String name);

    /**
     * Return all subscription entity.
     *
     * @return the list
     */
    List<SubscriptionEntity> findAll();
}
