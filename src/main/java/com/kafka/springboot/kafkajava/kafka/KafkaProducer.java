package com.kafka.springboot.kafkajava.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class KafkaProducer {

    private final String TOPIC = "lsy-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.target.topic}")
    private String topic;

    public void sendMessage(String message) {
        log.info("send log {}", message);
        kafkaTemplate.send(this.topic, String.format("current time: , Message -> %s %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")), message));
    }
}