package com.gonuclei.config.redis;

import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * The type Redis config.
 */
@SuppressWarnings("all")
@Configuration
public class RedisConfig {

  /**
   * The Redis host name.
   */
  @Value("${bizdirect.cache.redis.host}")
  private String redisHostName;

  /**
   * The Redis port.
   */
  @Value("${bizdirect.cache.redis.port}")
  private Integer redisPort;

  /**
   * The Data base.
   */
  @Value("${bizdirect.cache.redis.database}")
  private Integer dataBase;

  /**
   * The Connection timeout.
   */
  @Value("${bizdirect.cache.redis.connection-timeout-ms}")
  private Long connectionTimeout;

  /**
   * The Read time out.
   */
  @Value("${bizdirect.cache.redis.read-timeout-ms}")
  private Long readTimeOut;

  /**
   * The Max wait.
   */
  @Value("${bizdirect.cache.redis.max-wait-millis}")
  private Long maxWait;

  /**
   * The Max idle.
   */
  @Value("${bizdirect.cache.redis.max-idle}")
  private Integer maxIdle;

  /**
   * The Min idle.
   */
  @Value("${bizdirect.cache.redis.min-idle}")
  private Integer minIdle;

  /**
   * The Max total.
   */
  @Value("${bizdirect.cache.redis.max-idle}")
  private Integer maxTotal;


  /**
   * Jedis pool config jedis pool config.
   *
   * @return the jedis pool config
   */
  @Bean
  JedisPoolConfig jedisPoolConfig() {
    JedisPoolConfig poolConfig = new JedisPoolConfig();
    poolConfig.setMaxWaitMillis(maxWait);
    poolConfig.setMaxIdle(maxIdle);
    poolConfig.setMinIdle(minIdle);
    poolConfig.setMaxTotal(maxTotal);
    poolConfig.setTestOnBorrow(true);
    poolConfig.setTestOnReturn(true);
    poolConfig.setTestWhileIdle(true);
    return poolConfig;
  }

  /**
   * Jedis connection factory jedis connection factory.
   *
   * @return the jedis connection factory
   */
  @Bean
  JedisConnectionFactory jedisConnectionFactory() {

    RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(
      redisHostName,
      redisPort
    );

    configuration.setDatabase(dataBase);
    JedisClientConfiguration clientConfiguration =
      JedisClientConfiguration.builder().usePooling().poolConfig(jedisPoolConfig())
        .and()
        .connectTimeout(Duration.ofMillis(connectionTimeout))
        .readTimeout(Duration.ofMillis(readTimeOut))
        .build();

    return new JedisConnectionFactory(configuration, clientConfiguration);

  }

  /**
   * Redis template redis template.
   *
   * @return the redis template
   */
  @Bean
  RedisTemplate<String, Object> redisTemplate() {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(jedisConnectionFactory());
    return redisTemplate;
  }

}
