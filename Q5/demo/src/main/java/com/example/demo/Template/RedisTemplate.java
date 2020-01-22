//package com.example.demo.Template;
//
//import org.springframework.context.annotation.Bean;
//
//public class RedisTemplate {
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
//        jedisConFactory.setHostName("localhost");
//        jedisConFactory.setPort(6000);
//        jedisConFactory.setUsePool(true);
//        return jedisConFactory;
//    }
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(new StringRedisSerializer());
//        template.setValueSerializer(new StringRedisSerializer());
//        return template;
//    }
//
//}
