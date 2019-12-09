package com.newsletter.newsletter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newsletter.newsletter.DTO.UserRepository;

@Component
public class UserService {
	@Autowired UserRepository repo; 
}
