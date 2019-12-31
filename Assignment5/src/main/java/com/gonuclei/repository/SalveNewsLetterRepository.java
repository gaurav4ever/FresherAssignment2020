package com.gonuclei.repository;

import com.gonuclei.entities.NewsLetterEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalveNewsLetterRepository extends CrudRepository<NewsLetterEntity, Integer> {

    /**
     * Find by category list.
     *
     * @param category the category
     * @return the list
     */
    List<NewsLetterEntity> findByCategory(String category);

    /**
     * Find by name containing list.
     *
     * @param name the name
     * @return the list
     */
    List<NewsLetterEntity> findByNameContaining(String name);

    /**
     * Return all subscription entity.
     *
     * @return the list
     */
    List<NewsLetterEntity> findAll();
}
