package com.garage.kafka.controller;

import com.garage.kafka.producer.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class SenderController {

	@Autowired
	Sender sender;

	@Value("${target.service.name}")
    private String targetServiceName;



	@PostMapping("/send")
	public void createHistory(@Valid @RequestBody String dataString) {
		log.debug("message.. : " + dataString);

		sender.send(dataString);
	}

}
