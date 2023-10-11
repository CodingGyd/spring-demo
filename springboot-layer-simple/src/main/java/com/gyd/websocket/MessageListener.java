package com.gyd.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName MessageListener
 * @Description TODO
 * @Author guoyading
 * @Date 2023/10/11 11:03
 * @Version 1.0
 */
@Component
public class MessageListener implements org.springframework.data.redis.connection.MessageListener {

    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private WebSocketService webSocketService;
    @Override
    public void onMessage(Message message, byte[] pattern) {
        RedisSerializer<String> valueSerializer = redisTemplate.getValueSerializer();
        String value = valueSerializer.deserialize(message.getBody());
        if (null != value && value.length() > 0) {
            System.out.println("监听集群websocket消息--"+value);
            webSocketService.sendMessage(value);
         }
    }
}