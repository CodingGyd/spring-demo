package com.gyd.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName KafkaConsumer
 * @Description Kafka消费者
 * @Author guoyading
 * @Date 2023/10/26 14:37
 * @Version 1.0
 */
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }

}


