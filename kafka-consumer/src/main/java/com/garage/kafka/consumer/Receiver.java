package com.garage.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Receiver {
	
	@Autowired
    RestTemplate restTemplate;
	
	@Value("${target.service.name}")
    private String targetServiceName;


    @KafkaListener(topics = "${spring.kafka.group-id}")
    public void listen(@Payload String message) {
        log.debug("received message='{}'", message);
        
        String url = "http://" + targetServiceName + "/service/hit/history";
		log.debug("url:" + url);
		
		ResponseEntity<String> result = restTemplate.postForEntity(url, message, String.class);
		log.debug("result:" + result.getBody());
		
    }

}