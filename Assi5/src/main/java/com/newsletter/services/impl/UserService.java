package com.newsletter.services.impl;

import com.newsletter.dao.UserRepository;
import com.newsletter.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import com.newsletter.entities.UserEntity;

@Component
public class UserService {
  @Autowired
  private UserRepository repo;

  public void addUser(User user) {
    repo.save(user);
  }

  public List<User> getAllUsers() {
    return repo.findAll();
  }

  public User getUser(String email) {
    return repo.findById(email).get();
  }

  public void removeUser(String email) {
    repo.deleteById(email);
  }
}
