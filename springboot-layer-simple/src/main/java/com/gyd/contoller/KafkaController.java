package com.gyd.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName KafkaController
 * @Description Kafka生产消息接口
 * @Author guoyading
 * @Date 2023/10/26 14:35
 * @Version 1.0
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) {
        kafkaTemplate.send("my-topic", message);
    }

}

