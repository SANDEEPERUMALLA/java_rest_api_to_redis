package com.redis.config;

import com.redis.logging.Logger;
import com.redis.services.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration public class RedisConfig {

    @Bean
    public RedisService redisService(@Value("${redis.host}") String redisHost,
            @Value("${redis.port}") String redisPort, Logger logger) {
        return new RedisService(redisHost, redisPort, logger);
    }

    @Bean Logger logger(@Value("${log.dir}") String logDir) {
        System.out.println("logDir: " + logDir);
        return new Logger(logDir);
    }
}
