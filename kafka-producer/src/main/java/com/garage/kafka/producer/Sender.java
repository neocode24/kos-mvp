package com.garage.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Sender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.group-id}")
    private String topic;

    public void send(String message) {
        log.debug("sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }
}
