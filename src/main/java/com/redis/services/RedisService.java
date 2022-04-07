package com.redis.services;

import redis.clients.jedis.Jedis;

import java.net.URI;

public class RedisService {

    private Jedis jedis;

    public RedisService(String redisHost, String redisPort) {
        try {
            this.jedis = new Jedis(redisHost, Integer.parseInt(redisPort));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String get(String cacheKey) {
         return jedis.get(cacheKey);
    }

    public String put(String cacheKey, String cacheValue) {
        return jedis.set(cacheKey, cacheValue);
    }

}
