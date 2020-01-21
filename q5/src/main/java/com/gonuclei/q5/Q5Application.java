package com.gonuclei.q5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@EnableAutoConfiguration
public class Q5Application {

	@RequestMapping("/")
	String home(){
		return "Hello";
	}
	@RequestMapping("hello")
	String hello(){
		return "Let's see";
	}

	public static void main(String[] args) {
		SpringApplication.run(Q5Application.class, args);
	}

}
