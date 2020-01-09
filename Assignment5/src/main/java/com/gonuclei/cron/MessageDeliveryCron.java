package com.gonuclei.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * The type Message delivery cron.
 */
@Component
public class MessageDeliveryCron {

  /**
   * The constant LOGGER.
   */
  public static final Logger LOGGER = LoggerFactory.getLogger(MessageDeliveryCron.class);

  /**
   * Send mails.
   */
//@Scheduled(cron = "0 0 19 * * ?")
  @Scheduled(cron = "0 */10 * * * ?")
  public void sendMails() {
    LOGGER.info("Cron Active");
  }

}
