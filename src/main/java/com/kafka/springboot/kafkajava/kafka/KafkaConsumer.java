package com.kafka.springboot.kafkajava.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "lsy-topic", groupId = "group_id")
    public void receiveMessage(String message) {
        log.info("kafka Message -> {}", message);
    }
}
