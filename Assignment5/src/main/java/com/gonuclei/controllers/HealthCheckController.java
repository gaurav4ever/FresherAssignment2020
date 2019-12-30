package com.gonuclei.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Status resource to check the health of the application.
 * Returns a {@link HttpStatus#OK} response when healthy along with appVersion.
 */
@RestController
public class HealthCheckController {

  /**
   * application version bound from environment.
   */
  @Value("${bizdirect.app-version:1.0}")
  private String appVersion;

  @GetMapping(path = {"/appVersion", "/status"}, produces = {MediaType.TEXT_PLAIN_VALUE})
  public ResponseEntity<String> getAppVersion() {
    return new ResponseEntity<>(appVersion, HttpStatus.OK);
  }
  

}
