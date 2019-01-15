package com.garage.usagedata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.garage.usagedata.bean.Data_UsePtrn3monsRetv;
import com.garage.usagedata.bean.PK_UsePtrn3monsRetv;

public interface UsePtrn3monsRetvRepository extends CrudRepository<Data_UsePtrn3monsRetv, PK_UsePtrn3monsRetv> {

	Optional<List<Data_UsePtrn3monsRetv>> findBySvcContId(String svcContId);
}
