package com.garage.msa.repository;

import com.garage.msa.bean.UsageData;
import org.springframework.data.repository.CrudRepository;

public interface UsageDataRedisRepository extends CrudRepository<UsageData, String> {

}
