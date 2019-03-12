package com.ktds.cert.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktds.cert.bean.EchoBean;
import com.ktds.cert.repository.DataRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    DataRedisRepository repository;


    @GetMapping("all")
    public List<EchoBean> getDatas() {
        log.debug("all list");

        List<EchoBean> list = new ArrayList<>();
        Iterable<EchoBean> beans = repository.findAll();

        beans.forEach(list::add);
        return list;
    }


    @PostMapping("/create")
    public ResponseEntity<String> insertData(@Valid @RequestBody Map requestMap) {

        log.debug("redisTemplate:" + redisTemplate.toString());

        EchoBean bean = new ObjectMapper().convertValue(requestMap, EchoBean.class);

        Optional<EchoBean> savedData = Optional.ofNullable(repository.save(bean));
        if ( savedData.isPresent() ) {
            return new ResponseEntity<>("Create", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Fail", HttpStatus.EXPECTATION_FAILED);
        }
    }

}
