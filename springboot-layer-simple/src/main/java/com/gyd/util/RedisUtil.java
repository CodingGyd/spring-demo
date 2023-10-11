package com.gyd.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName RedisUtil
 * @Description TODO
 * @Author guoyading
 * @Date 2023/10/11 10:47
 * @Version 1.0
 */
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String,String> redisTemplate;
    /**
     * 发布
     *
     * @param key
     */
    public void publish(String key, String value) {
        redisTemplate.convertAndSend(key, value);
    }
}