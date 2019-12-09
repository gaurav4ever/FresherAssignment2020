package com.newsletter.newsletter.DTO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsletter.newsletter.model.User;

public interface UserRepository extends JpaRepository<User,String>{

}
