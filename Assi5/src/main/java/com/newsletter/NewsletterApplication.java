package com.newsletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NewsletterApplication {

  public static void main(String[] args) {
    SpringApplication.run(NewsletterApplication.class, args);
  }

}
