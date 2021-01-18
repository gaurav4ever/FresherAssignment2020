package com.gonuclei.controllers;

import com.gonuclei.constants.Constants;
import com.gonuclei.kafka.MyProducer;
import com.gonuclei.models.dto.EmailDto;
import com.gonuclei.services.impl.MailSenderImpl;
import com.gonuclei.mapper.UserSubscriptionObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Email controller.
 */
@Controller
@RequestMapping(path = "/email")
public class EmailController {

  /**
   * The constant gson.
   */
  private static final Gson gson = new Gson();
  /**
   * The Mail sender.
   */
  @Autowired
  private MailSenderImpl mailSenderImpl;
  /**
   * The User subscription object mapper.
   */
  @Autowired
  private UserSubscriptionObjectMapper userSubscriptionObjectMapper;
  /**
   * The My producer.
   */
  @Autowired
  private MyProducer myProducer;

  /**
   * Send email response entity.
   *
   * @param emailDto the email dto
   * @return the response entity
   * @throws IOException        the io exception
   * @throws MessagingException the messaging exception
   */
  @PostMapping(path = "/send")
  ResponseEntity<?> sendEmail(@RequestBody EmailDto emailDto) {
    myProducer.sendMessage(Constants.TOPIC_PATTERN + emailDto.getCategory(), gson.toJson(emailDto));
    return new ResponseEntity<>("In progress...", HttpStatus.OK);
  }
}
