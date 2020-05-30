package com.kafka.springboot.kafkajava.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping(value = "/kafka/publish")
    public void sendMessageToKafkaTopic(@RequestParam String message) {
        this.kafkaProducer.sendMessage(message);
    }
}
