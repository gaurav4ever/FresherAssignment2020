package com.gonuclei.repositories;

import com.bizdirect.data.annotations.MasterRepository;
import com.gonuclei.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Master user repository.
 */
@MasterRepository
public interface MasterUserRepository extends JpaRepository<UserEntity, Long> {

}
