package com.gonuclei.kafka;

import com.bizdirect.commons.constant.BizdirectCommonBeans;
import com.gonuclei.bo.NewsLetterBo;
import com.gonuclei.constants.Constants;
import com.gonuclei.exceptions.CustomException;
import com.gonuclei.services.UserSubscriptionService;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@DependsOn(BizdirectCommonBeans.KafkaAutoConfigBeans.KAFKA_AUTO_CONFIGURATION_BEAN)
public class Consumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

  @Autowired
  UserSubscriptionService userSubscriptionService;

  Gson gson = new Gson();

  /**
   * On message.
   *
   * @param newsLetterString the value
   */
  /*
   * On message.
   *
   * @param consumerRecord the consumer record
   */
  @KafkaListener(
    topicPattern = Constants.TOPIC_PATTERN_MATCH,
    containerFactory = Constants.KAFKA_CONTAINER_FACTORY
  )
  public void onMessage(final String newsLetterString) {

    try {
      NewsLetterBo newsLetterBo = gson.fromJson(newsLetterString, NewsLetterBo.class);
      gson.fromJson(newsLetterString, NewsLetterBo.class);
      userSubscriptionService.sendNewsLetter(newsLetterBo);
    } catch (Exception e){
      throw new CustomException("Cannot convert into Json", HttpStatus.BAD_REQUEST);
    }

  }

}
