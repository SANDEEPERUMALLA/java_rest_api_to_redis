package com.redis.services;

import com.redis.logging.Logger;
import redis.clients.jedis.Jedis;

public class RedisService {

    private Jedis jedis;
    private Logger logger;

    public RedisService(String redisHost, String redisPort, Logger logger) {
        try {
            logger.log("Redis host: " + redisHost);
            logger.log("Redis Port: " + redisPort);
            this.jedis = new Jedis(redisHost, Integer.parseInt(redisPort));
            this.logger = logger;
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String get(String cacheKey) {
        logger.log("Get Call with Cache Key: " + cacheKey);
        return jedis.get(cacheKey);
    }

    public String put(String cacheKey, String cacheValue) {
        logger.log("Put Call with Cache Key: " + cacheKey + ", CacheValue: " + cacheValue);
        return jedis.set(cacheKey, cacheValue);
    }

}
