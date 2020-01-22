package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import com.example.demo.Model.NewsLetter;
import com.example.demo.Model.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository usersRepo;

    @GetMapping("/users")
    public List<User> index() {
        return usersRepo.findAll();
    }

    @PostMapping("/users")
        public User create(@RequestBody User user){

            return usersRepo.save(user);
        }
    }

