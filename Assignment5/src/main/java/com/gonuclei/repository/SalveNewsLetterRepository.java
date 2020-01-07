package com.gonuclei.repository;

import com.gonuclei.entities.NewsLetterEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Salve news letter repository.
 */
public interface SalveNewsLetterRepository extends CrudRepository<NewsLetterEntity, Integer> {


    /**
     * Find by id news letter entity.
     *
     * @param id the id
     * @return the news letter entity
     */
    NewsLetterEntity findById(Long id);

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
