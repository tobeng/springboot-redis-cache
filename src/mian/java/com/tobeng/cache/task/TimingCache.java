package com.tobeng.cache.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @package com.tobeng.cache.task
 */
@Component
@Slf4j
@EnableScheduling
public class TimingCache {

    private static final String KEY = "test";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Scheduled(fixedRate = 1000*60*5)
    private void task(){
        stringRedisTemplate.opsForValue().set(KEY, "ceshi", 10, TimeUnit.MINUTES);
    }

}
