package com.gyd.config;


import com.gyd.websocket.MessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @Description redis消息订阅配置类
 */
@Configuration
public class RedisSubscriberConfig {

    /**
     * 消息监听适配器，注入接受消息方法
     *
     * @param receiver
     * @return
     */
    @Bean
    public MessageListenerAdapter messageListenerAdapter(MessageListener receiver) {
        MessageListenerAdapter adapter = new MessageListenerAdapter(receiver);
        return adapter;
    }
    /**
     * 创建消息监听容器
     *
     * @param redisConnectionFactory
     * @param messageListenerAdapter
     * @return
     */
    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new PatternTopic("websocket"));
        return redisMessageListenerContainer;
    }
}