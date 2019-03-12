/****************************************************************************************************
 * 
 *  Copyright ⓒ 2018 kt corp. All rights reserved.
 *
 *  This is a proprietary software of kt corp, and you may not use this file except in
 *  compliance with license agreement with kt corp. Any redistribution or use of this
 *  software, with or without modification shall be strictly prohibited without prior written
 *  approval of kt corp, and the copyright notice above does not evidence any actual or
 *  intended publication of such software.
 *
 *
 *****************************************************************************************************
 * date        Modifier Description
 *****************************************************************************************************
 * 2019. 3. 6. 82022961
 * 
 *****************************************************************************************************/
package com.ktds.cert.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 82022961
 * @Desction 
 */

@Slf4j
@RestController
@RequestMapping("/cert")
public class CertController {
	

	@Autowired
    RestTemplate restTemplate;




	@GetMapping("/url/{strUri}")
	public ResponseEntity<String> callService(@PathVariable("strUri") String strUri) {
		
		log.debug("Start [callService] ...");
		
		String url = "https://" + strUri;
		log.debug("call service url:" + url);
		
		ResponseEntity<String> response = restTemplate.exchange(
	            url,
	            HttpMethod.GET,
	            null,
	            String.class);
		
		Optional<String> data = Optional.ofNullable(response.getBody());
		if ( data.isPresent() ) {
			log.debug("data:" + data.get().toString());
			return new ResponseEntity<>(data.get(), HttpStatus.OK);
		} else {
			log.debug("No data found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> call() {
		log.debug("start call");
		
		ResponseEntity<String> response = restTemplate.exchange(
				"https://micro-svc.container.ipc.kt.com/svc1/hello",
				HttpMethod.GET,
				null,
				String.class);
		
		log.debug("response:" + response);
		
		return response;
	}


	@GetMapping("/mail")
	public ResponseEntity<String> callMail() {
		log.debug("start call");

		ResponseEntity<String> response = restTemplate.exchange(
				"https://groupmail.kt.com",
				HttpMethod.GET,
				null,
				String.class);

		log.debug("response:" + response);

		return response;
	}
}

