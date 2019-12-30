package com.gonuclei.Assignment5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
