package com.gonuclei.repo.master;

import com.bizdirect.data.annotations.MasterRepository;
import com.gonuclei.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Master user repository.
 */
@MasterRepository
public interface MasterUserRepository extends JpaRepository<UserEntity, Long> {

}
