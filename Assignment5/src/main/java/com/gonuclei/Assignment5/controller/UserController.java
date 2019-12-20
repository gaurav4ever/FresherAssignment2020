package com.gonuclei.Assignment5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/home")
    public String greet() {
        return "Welcome to newsletter";
    }
}
