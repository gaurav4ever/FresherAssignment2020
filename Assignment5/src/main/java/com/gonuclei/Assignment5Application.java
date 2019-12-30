package com.gonuclei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration
@EnableScheduling
@SpringBootApplication
public class NewsLetterApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(NewsLetterApplication.class, args);
  }
}
