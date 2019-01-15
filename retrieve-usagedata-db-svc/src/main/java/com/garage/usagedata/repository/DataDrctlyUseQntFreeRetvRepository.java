package com.garage.usagedata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.garage.usagedata.bean.Data_DrctlyUseQntFreeRetv;
import com.garage.usagedata.bean.PK_DrctlyUseQntFreeRetv;

public interface DataDrctlyUseQntFreeRetvRepository extends CrudRepository<Data_DrctlyUseQntFreeRetv, PK_DrctlyUseQntFreeRetv> {
	@Query(value = "SELECT * FROM drctly_use_qnt_free_retv WHERE svc_cont_id = ?1 and retv_st_dt =?2 and sbscr_no=?3", nativeQuery = true)
	public Optional<List<Data_DrctlyUseQntFreeRetv>> findByBillRetrieve(@Param("svcContId") String svcContId,
            @Param("retvStDt") String retvStDt,@Param("sbscrNo") String sbscrNo);

}
