package com.ramraje.myFirstProject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T get(String key, Class<T> entityClass) {
        try {
            String jsonData = redisTemplate.opsForValue().get(key);
            if (jsonData != null) {
                return objectMapper.readValue(jsonData, entityClass);
            }
        } catch (Exception e) {
            log.error("Error fetching key: {} from Redis", key, e);
        }
        return null;
    }

    public void set(String key, Object value, Long ttl) {
        try {
            String jsonData = objectMapper.writeValueAsString(value);
            redisTemplate.opsForValue().set(key, jsonData, ttl, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("Error setting key: {} in Redis", key, e);
        }
    }
}
