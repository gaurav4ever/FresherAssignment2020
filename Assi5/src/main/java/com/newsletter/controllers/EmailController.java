package com.newsletter.controllers;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * The type Email controller.
 */
@Controller
public class EmailController {

  @Autowired
  private transient JavaMailSender javaMailSender;

  private void sendEmail() {
    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setTo("aashish.gupta191097@gmail.com");
    msg.setSubject("Testing from Spring Boot");
    msg.setText("Hello World");
    javaMailSender.send(msg);
  }

  /**
   * Run.
   */
  @RequestMapping("/sendmail")
  public void run() {
    System.out.println("Sending Email...");
    try {
      sendEmail();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("Done");
  }

}
