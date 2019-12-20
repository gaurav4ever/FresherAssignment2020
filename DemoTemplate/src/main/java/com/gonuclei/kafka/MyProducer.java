package com.gonuclei.kafka;

import com.bizdirect.KafkaContextHolder;
import com.bizdirect.commons.constant.BizdirectCommonBeans;
import com.gonuclei.constants.Constants;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * The type My producer.
 */
@Service
@DependsOn(BizdirectCommonBeans.KafkaAutoConfigBeans.KAFKA_AUTO_CONFIGURATION_BEAN)
public class MyProducer {

  /**
   * The kafka context holder.
   */
  private final KafkaContextHolder kafkaContextHolder;


  /**
   * Instantiates a new notification kafka producer.
   *
   * @param kafkaContextHolder the kafka context holder
   */
  public MyProducer(
    final @Qualifier(Constants.KAFKA_CONTEXT_HOLDER) KafkaContextHolder kafkaContextHolder) {
    super();
    this.kafkaContextHolder = kafkaContextHolder;
  }


  /**
   * Send bizdirect generic request message.
   *
   * @param topic the notification topic name
   * @param message           the request data
   */
  public void sendMessage(final String topic, final String message) {
    kafkaContextHolder.getKafkaTemplate().send(topic, message);
  }
}
