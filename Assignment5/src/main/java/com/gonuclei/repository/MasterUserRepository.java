package com.gonuclei.repository;

import com.gonuclei.entities.NewsLetterEntity;
import com.gonuclei.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Master user repository.
 */
public interface MasterUserRepository extends CrudRepository<UserEntity, Integer> {

}
