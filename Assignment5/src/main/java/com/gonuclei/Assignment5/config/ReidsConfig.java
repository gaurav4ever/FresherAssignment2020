package com.gonuclei.Assignment5.config;

import com.gonuclei.Assignment5.model.Subscription;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class ReidsConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
//        final JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxTotal(5);
//        poolConfig.setTestOnBorrow(true);
//        poolConfig.setTestOnReturn(true);

        final JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        //poolConfig);
//        connectionFactory.setUsePool(true);
//        connectionFactory.setHostName("localhost");
//        connectionFactory.setPort(6379);
        return connectionFactory;
    }

    @Bean
    public RedisTemplate<String, Subscription> redisTemplate() {
        final RedisTemplate<String, Subscription> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
}
