package com.garage.usagedata.controller;

import java.util.Optional;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.garage.usagedata.bean.Data_DrctlyUseQntUsageRetv;
import com.garage.usagedata.bean.Data_DrctlyUseQntFreeRetv;
import com.garage.usagedata.bean.Data_DrctlyUseQntMyOllehListRetv;

import com.garage.usagedata.bean.PK_DrctlyUseQntUsageRetv;
import com.garage.usagedata.bean.PK_DrctlyUseQntFreeRetv;

import com.garage.usagedata.repository.DataDrctlyUseQntFreeRetvRepository;
import com.garage.usagedata.repository.DataDrctlyUseQntUsageRetvRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

@Slf4j
@RestController
@RequestMapping("/usage/retrieveBillPreTmonUseQntMyOlleh")
public class DataSvcDrctlyUseQntMyOllehListRetvController {
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	DataDrctlyUseQntFreeRetvRepository repFree;
	
	@Autowired
	DataDrctlyUseQntUsageRetvRepository repUsage;
	
	@Value("${target.service.name}")
    private String targetServiceName;

	@GetMapping("/{svcContId}/{retvStDt}/{sbscrNo}")
	public ResponseEntity<Data_DrctlyUseQntMyOllehListRetv> getData(@PathVariable("svcContId") String svcContId, @PathVariable("retvStDt") String retvStDt,@PathVariable("sbscrNo") String sbscrNo) {
			
		log.debug("Get Data with ID = " + svcContId + ", " + retvStDt + ", " +  sbscrNo  + "...");
		
//		Optional<Data_DrctlyUseQntFreeRetv> freeData = repFree.findById(new PK_DrctlyUseQntFreeRetv(svcContId, retvStDt, sbscrNo, " "));
//		Optional<Data_DrctlyUseQntUsageRetv> usageData = repUsage.findById(new PK_DrctlyUseQntUsageRetv(svcContId, retvStDt, sbscrNo));
		
//		List<Data_DrctlyUseQntFreeRetv> freeData = repFree.findByBillRetrieve(svcContId, retvStDt, sbscrNo);
		//List<Data_DrctlyUseQntFreeRetv> freeData = repFree.findByBillRetrieve(@Param(svcContId) String svcContId, @Param(retvStDt) String retvStDt, @Param(sbscrNo) String sbscrNo);
		Optional<List<Data_DrctlyUseQntFreeRetv>> freeData = repFree.findByBillRetrieve(svcContId,retvStDt,sbscrNo);
		Optional<List<Data_DrctlyUseQntUsageRetv>> usageData = repUsage.findByBillRetrieve(svcContId,retvStDt,sbscrNo);
		
		Data_DrctlyUseQntMyOllehListRetv ollehData = new Data_DrctlyUseQntMyOllehListRetv(freeData,usageData);
		
		ollehData.setDayFreeYn("N");
		ollehData.setPerdFlag("0");
		ollehData.setToongFlag("0");
		
		// db에 있는 경우
		if (usageData.isPresent()) {
			
			log.debug("query data:" + usageData.get().toString());
			
			// redisKey는 서비스명 + 호출 PK
			String redisKey = "dataSvcDrctlyUseQntList" + "-" + svcContId + "-" + retvStDt + "-" + sbscrNo;
			
			String url = "http://" + targetServiceName + "/cache/create/" + redisKey;
			
			// 결과를 Cache Manager로 전달. cache 반영 처리 위임.
			//restTemplate.postForEntity(url, data.get(), Data_DataSvcDrctlyUseQntList.class);
						
			return new ResponseEntity<>(ollehData, HttpStatus.OK);
		} 
		// db에 없는 경우. 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}