package com.gonuclei.kafka;


import com.bizdirect.commons.constant.BizdirectCommonBeans;
import com.gonuclei.constants.Constants;
import com.gonuclei.exceptions.UserNotFoundException;
import com.gonuclei.models.bo.EmailBo;
import com.gonuclei.services.impl.MailSenderImpl;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * The type My consumer.
 */
@Configuration
@DependsOn(BizdirectCommonBeans.KafkaAutoConfigBeans.KAFKA_AUTO_CONFIGURATION_BEAN)
public class MyConsumer {

  /**
   * The constant logger.
   */
  private static final Logger logger = LoggerFactory.getLogger(MyConsumer.class);
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
   * On message.
   *
   * @param message the message
   */
  @KafkaListener(
    topicPattern = Constants.KAFKA_TOPIC_PATTERN,
    containerFactory = Constants.KAFKA_CONTAINER_FACTORY
  )
  public void onMessage(final String message) {
    EmailBo emailBo = gson.fromJson(message, EmailBo.class);
    try {
      mailSenderImpl.sendNewsLetterMail(emailBo);
    } catch (UserNotFoundException e) {
      logger.error(e.getMessage());
    }
  }
}
