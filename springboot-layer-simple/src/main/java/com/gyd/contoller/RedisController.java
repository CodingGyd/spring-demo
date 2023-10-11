package com.gyd.contoller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisTemplate redisTemplate;

    public RedisController(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/save")
    public String save(String key, String value){
        redisTemplate.opsForValue().set(key, value);
        return "success";
    }

    @GetMapping("/get")
    public String get(String key){
        Object value = redisTemplate.opsForValue().get(key);
        return null != value ? (String) value :null;
    }
}
