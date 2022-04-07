package com.redis.controllers;

import com.redis.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("get/{cacheKey}")
    public String get(@PathVariable("cacheKey") String cacheKey) {
        return redisService.get(cacheKey);
    }

    @GetMapping("put/{cacheKey}/value/{cacheValue}")
    public String put(@PathVariable("cacheKey") String cacheKey,
            @PathVariable("cacheValue") String cacheValue) {
        return redisService.put(cacheKey, cacheValue);
    }
}
