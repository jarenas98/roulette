package com.masiv.roulette.roulette.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Configuration
@EnableRedisRepositories
public class RedisConfig {
	  @Bean
	  public RedisConnectionFactory connectionFactory() {
	    return new JedisConnectionFactory();
	  }

	  @Bean
	  @Primary
	  public RedisTemplate<?, ?> redisTemplate() {
	    RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
	    template.setConnectionFactory(connectionFactory());
	    
	    return template;
	  }
}
