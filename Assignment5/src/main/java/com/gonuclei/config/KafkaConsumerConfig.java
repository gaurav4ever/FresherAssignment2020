package com.gonuclei.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


/**
 * The type Kafka consumer config.
 */
@EnableKafka
@Configuration
public class KafkaConsumerConfig {
  //JSON Consumer Factory

  private KafkaProperties kafkaProperties;

  /**
   * Instantiates a new Kafka consumer config.
   *
   * @param kafkaProperties the kafka properties
   */
  @Autowired
  public KafkaConsumerConfig(KafkaProperties kafkaProperties){
    this.kafkaProperties = kafkaProperties;
  }

  /**
   * Consumer factory consumer factory.
   *
   * @return the consumer factory
   */
  @Bean
  public ConsumerFactory<String, Object> consumerFactory() {
    final JsonDeserializer<Object> jsonDeserializer = new JsonDeserializer<>();
    jsonDeserializer.addTrustedPackages("*");
    return new DefaultKafkaConsumerFactory<>(
        kafkaProperties.buildConsumerProperties(), new StringDeserializer(), jsonDeserializer
    );
  }

  /**
   * Kafka listener container factory concurrent kafka listener container factory.
   *
   * @return the concurrent kafka listener container factory
   */
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Object> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());

    return factory;
  }
}
