package com.newsletter.dao;

//import com.newsletter.entities.UserEntity;
import com.newsletter.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
