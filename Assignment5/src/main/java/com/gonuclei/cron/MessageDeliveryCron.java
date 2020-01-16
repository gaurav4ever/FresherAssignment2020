package com.gonuclei.cron;

import com.gonuclei.bos.NewsLetterBo;
import com.gonuclei.bos.SubscriptionBo;
import com.gonuclei.exception.SubscriptionNotFoundException;
import com.gonuclei.service.EmailService;
import com.gonuclei.service.transactions.NewsLetterTransactionService;
import com.gonuclei.service.transactions.SubscriptionTransactionService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * The type Message delivery cron.
 */

@Component
public class MessageDeliveryCron {

  private final SubscriptionTransactionService subscriptionTransactionService;
  private final NewsLetterTransactionService newsLetterTransactionService;
  private final EmailService emailService;

  @Autowired
  public MessageDeliveryCron(SubscriptionTransactionService subscriptionTransactionService, NewsLetterTransactionService newsLetterTransactionService, EmailService emailService) {
    this.subscriptionTransactionService = subscriptionTransactionService;
    this.newsLetterTransactionService = newsLetterTransactionService;
    this.emailService = emailService;
  }

  /**
   * The constant LOGGER.
   */
  public static final Logger LOGGER = LoggerFactory.getLogger(MessageDeliveryCron.class);

  private Map<String, Object> consumerProps() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    //props.put(ConsumerConfig.GROUP_ID_CONFIG, "");
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
    props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
    props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    return props;
  }

  private KafkaMessageListenerContainer<String, Object> createContainer(ContainerProperties containerProps) {
    Map<String, Object> props = consumerProps();
    DefaultKafkaConsumerFactory<String, Object> cf =
        new DefaultKafkaConsumerFactory<>(props);
    KafkaMessageListenerContainer<String, Object> container =
        new KafkaMessageListenerContainer<>(cf, containerProps);
    return container;
  }

  /**
   * Send mails.
   */
//@Scheduled(cron = "0 0 19 * * ?")
  @Scheduled(cron = "0 * * * * ?")
  public void sendMails() throws SubscriptionNotFoundException {
    LOGGER.info("Cron Active");


    newsLetterTransactionService.getAllNewsLettersBo()
        .forEach(newsLetterBo -> newsLetterBo.getSubscribedUsers()
            .forEach(user -> emailService.sendSimpleMessage(user.getEmail(), "Demo From Assignment5 Application", "Demo from spring boot application!")));
//    List<NewsLetterBo> newsLetters =
//    List<SubscriptionBo> subscriptions = subscriptionTransactionService.getAllSubscriptionBo();
//    subscriptions.forEach(subscriptionBo -> LOGGER.info("Sending Email To" + subscriptionBo.getUser().getEmail()));
//    //List<NewsLetterBo> newsLetters = newsLetterTransactionService.getAllNewsLettersBo();
//    Set<String> kafkaTopics = new HashSet<>();
//    subscriptions.forEach(subscriptionBo -> kafkaTopics.add(subscriptionBo.getNewsLetter().getKafkaTopic()));
//    ContainerProperties containerProps = new ContainerProperties((String[]) kafkaTopics.toArray(new String[0]));
//    KafkaMessageListenerContainer<String, Object> container = createContainer(containerProps);
//    containerProps.setMessageListener(new MessageListener<String, Object>() {
//
//      @Override
//      public void onMessage(ConsumerRecord<String, Object> message) {
//        subscriptions.forEach(
//            abstractUserModel -> LOGGER.info("Mail To: " + abstractUserModel.getUser().getEmail())
//        );
//      }
//
//    });
//    container.setBeanName("testAuto");
//    container.start();
  }

}
