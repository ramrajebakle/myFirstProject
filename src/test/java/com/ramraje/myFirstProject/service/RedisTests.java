package com.ramraje.myFirstProject.service;//package com.ramraje.myFirstProject.service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
@SpringBootTest
public class RedisTests {



    @Autowired
    private RedisTemplate redisTemplate;

    @Disabled
    @Test
    void testSendEmail() {
        redisTemplate.opsForValue().set("email","bakleramraje@gmail.com");

        Object email = redisTemplate.opsForValue().get("email");
        int a=1;
    }
}
