package com.gonuclei.repository;

import com.gonuclei.entities.NewsLetterEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Master news letter repository.
 */
public interface MasterNewsLetterRepository extends CrudRepository<NewsLetterEntity, Long> {

}
