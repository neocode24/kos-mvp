package com.garage.msa.controller;

import com.garage.msa.bean.UsageData;
import com.garage.msa.repository.UsageDataRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/usage")
public class UsageDataController {
	
	@Autowired
    RestTemplate restTemplate;
	
	@Autowired
	UsageDataRedisRepository usageDataRedisRepository;


	
	@GetMapping("/{svcContId}/{retvYm}")
	public ResponseEntity<UsageData> getUsageData(@PathVariable("svcContId") String svcContId, @PathVariable("retvYm") String retvYm) {

		log.debug("Start [UsageData] service...");

		String redisKey = svcContId + "-" + retvYm;
		
		// redis cache 에는 wrapped class (UsageData)로 거래 함. key는 svcContId + retvYm
		Optional<UsageData> usageData = usageDataRedisRepository.findById(redisKey);
		
		// cache에 있는 경우. wrapped class 안에 있는 실제 객체(Data_UsePtrn3monsRetv)로 결과 제공함.
		if (usageData.isPresent()) {
			log.debug("Return usage data from Redis");
			return new ResponseEntity<>(usageData.get(), HttpStatus.OK);
		} 
		// cache에 없는 경우. 
		else {
			log.debug("No data found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
