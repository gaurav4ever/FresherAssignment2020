package com.newsletter.newsletter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.newsletter.newsletter.service.UserService;

@RestController
public class UserController {
	@Autowired UserService service;
	
	
}
