package com.garage.usagedata.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
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

import com.garage.usagedata.bean.Data_DataTotDtlRetvProdNm;
import com.garage.usagedata.bean.PK_DataTotDtlRetvProdNm;
import com.garage.usagedata.repository.DataTotDtlRetvProdNmRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/usage/dataTotDtlRetvProdNm")
public class DataTotDtlRetvProdNmController {
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	DataTotDtlRetvProdNmRepository repository;
	
	@Value("${target.service.name}")
    private String targetServiceName;

	@GetMapping("/{svcContId}/{rqtDate}/{mdn}")
	public ResponseEntity<List<Data_DataTotDtlRetvProdNm>> getData(@PathVariable("svcContId") String svcContId, @PathVariable("rqtDate") String rqtDate, @PathVariable("mdn") String mdn) {
		
		log.debug("Get Data with ID = " + svcContId + ", " + rqtDate + ", " + mdn + "...");
		Optional<List<Data_DataTotDtlRetvProdNm>> data = repository.findByTotDtl(svcContId,rqtDate,mdn);

		// db에 있는 경우
		if (data.isPresent()) {
			
			// redisKey는 서비스명 + 호출 PK
			String redisKey = "dataTotDtlRetvProdNm" + "-" + svcContId + "-" + rqtDate + "-" + mdn;
			
			//log.debug("dataTotDtlRetvProdNm" + "-" + svcContId + "-" + rqtDate + "-" + mdn);
			
			String url = "http://" + targetServiceName + "/cache/create/" + redisKey;
			
			log.debug("db result:" + data.get());
			
			// 결과를 Cache Manager로 전달. cache 반영 처리 위임.
			//restTemplate.postForEntity(url, data.get(), Data_DataTotDtlRetvProdNm.class);
			//ResponseEntity<String> cacheResult = restTemplate.postForEntity(url, data.get(), String.class);						
			return new ResponseEntity<>(data.get(), HttpStatus.OK);
		} 
		// db에 없는 경우. 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create")
	public Data_DataTotDtlRetvProdNm createData(@Valid @RequestBody Data_DataTotDtlRetvProdNm data) {
		log.debug("Create Data : " + data.toString() + "...");

		return repository.save(data);
	}

	@PutMapping("/{svcContId}/{rqtDate}/{mdn}")
	public ResponseEntity<Data_DataTotDtlRetvProdNm> updateData(@PathVariable("svcContId") String svcContId, @PathVariable("rqtDate") String rqtDate,@PathVariable("mdn") String mdn, @RequestBody Data_DataTotDtlRetvProdNm data) {
		log.debug("Update Data with ID = " + svcContId + ", " + rqtDate + ", " + mdn + "...");
		Optional<Data_DataTotDtlRetvProdNm> findedData = repository.findById(new PK_DataTotDtlRetvProdNm(svcContId, rqtDate, mdn));
		
		if (findedData.isPresent()) {
			Data_DataTotDtlRetvProdNm savedData = findedData.get();
			
			savedData.setProdSeq(data.getProdSeq());
			savedData.setSvcCd(data.getSvcCd());
			
			savedData.setEfctStDate(data.getEfctStDate());
			savedData.setEfctFnsDate(data.getEfctFnsDate());
		
			savedData.setProdNm(data.getProdNm());
			savedData.setTmonPrvQnt(data.getTmonPrvQnt());
			savedData.setCfwdPrvQnt(data.getCfwdPrvQnt());
			savedData.setUseQnt(data.getUseQnt());
			
			Data_DataTotDtlRetvProdNm updatedData = repository.save(savedData);
			return new ResponseEntity<>(updatedData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{svcContId}/{rqtDate}/{mdn}")
	public ResponseEntity<String> deleteData(@PathVariable("svcContId") String svcContId, @PathVariable("rqtDate") String rqtDate, @PathVariable("mdn") String mdn) {
		log.debug("Delete Data with ID = " + svcContId + ", " + rqtDate + ", " + mdn + "...");

		try {
			repository.deleteById(new PK_DataTotDtlRetvProdNm(svcContId, rqtDate, mdn));
		} catch (Exception e) {
			return new ResponseEntity<>("Fail to delete!", HttpStatus.EXPECTATION_FAILED);
		}

		return new ResponseEntity<>("Data has been deleted!", HttpStatus.OK);
	}
	
}
