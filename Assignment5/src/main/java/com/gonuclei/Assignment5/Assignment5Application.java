package com.gonuclei.Assignment5;

import com.gonuclei.Assignment5.model.Subscription;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@SpringBootApplication
public class Assignment5Application {

//	@Bean
//	public JedisConnectionFactory redisConnectionFactory() {
//		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("server", 6379);
//		return new JedisConnectionFactory(config);
//	}
//
//	@Bean
//	public RedisTemplate<String, Subscription> redisTemplate() {
//		final RedisTemplate<String, Subscription> template = new RedisTemplate<>();
//		template.setConnectionFactory(redisConnectionFactory());
//		template.setValueSerializer(new GenericToStringSerializer<>(Subscription.class));
//		return template;
//	}

	public static void main(String[] args) {
		SpringApplication.run(Assignment5Application.class, args);
	}

}
