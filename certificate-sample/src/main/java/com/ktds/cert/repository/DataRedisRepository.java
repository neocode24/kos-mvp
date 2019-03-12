package com.ktds.cert.repository;

import com.ktds.cert.bean.EchoBean;
import org.springframework.data.repository.CrudRepository;

public interface DataRedisRepository extends CrudRepository<EchoBean, String> {

}
