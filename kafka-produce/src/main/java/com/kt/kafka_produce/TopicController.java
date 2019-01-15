package com.kt.kafka_produce;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produceTopic")
public class TopicController {


	@Value("${bootstrap.servers}")
	private String bootstrapServers;


	@GetMapping("/{key}/{value}")
	public String produceTopic(@PathVariable("key") String key, @PathVariable("value") String value) {

		System.out.println(bootstrapServers);
		Properties configs = new Properties();
		configs.put("bootstrap.servers", bootstrapServers);
		configs.put("acks", "all");
		configs.put("block.on.buffer.full", "true");
		configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> producer = new KafkaProducer<>(configs);
		try {
			producer.send(new ProducerRecord<>(key, value),
					(metadata, exception) -> {
						if (metadata != null) {
							System.out.println(
									"partition(" + metadata.partition() + "), offset(" + metadata.offset() + ")");
						} else {
							exception.printStackTrace();
						}
					});
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			producer.flush();
			producer.close();	
		}
		return "ok";
	}

}
