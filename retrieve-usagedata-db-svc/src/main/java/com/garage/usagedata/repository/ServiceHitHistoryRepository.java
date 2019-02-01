package com.garage.usagedata.repository;

import com.garage.usagedata.bean.ServiceHitHistoryBean;

import org.springframework.data.repository.CrudRepository;

public interface ServiceHitHistoryRepository extends CrudRepository<ServiceHitHistoryBean, Long> {

}
