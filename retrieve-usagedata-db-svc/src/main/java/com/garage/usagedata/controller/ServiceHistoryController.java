package com.garage.usagedata.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.garage.usagedata.bean.ServiceHitHistoryBean;
import com.garage.usagedata.repository.ServiceHitHistoryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/service")
public class ServiceHistoryController {
	
	@Autowired
	ServiceHitHistoryRepository repository;

	@PostMapping("/hit/history")
	public ServiceHitHistoryBean createHistory(@Valid @RequestBody String dataString) throws JsonParseException, JsonMappingException, IOException {
		log.debug("Enter.. : " + dataString);
		
		ServiceHitHistoryBean data = new ObjectMapper().readValue(dataString, ServiceHitHistoryBean.class);
		log.debug("string to object:" + data.toString());
		
		return repository.save(data);
	}
	
}
