package com.garage.usagedata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.garage.usagedata.bean.Data_DrctlyUseQntFreeRetv;
import com.garage.usagedata.bean.Data_DrctlyUseQntUsageRetv;
import com.garage.usagedata.bean.PK_DrctlyUseQntUsageRetv;

public interface DataDrctlyUseQntUsageRetvRepository extends CrudRepository<Data_DrctlyUseQntUsageRetv, PK_DrctlyUseQntUsageRetv> {
	//@Query(value = "SELECT f FROM drctly_use_qnt_usage_retv f WHERE f.svc_cont_id = :svcContId and f.retv_st_dt =:retvStDt and f.sbscr_no=:sbscrNo", nativeQuery = true)
//	public List<Data_DrctlyUseQntUsageRetv> findByBillRetrieve(@Param("svcContId") String svcContId,
  //          @Param("retvStDt") String retvStDt,@Param("sbscrNo") String sbscrNo);
	//public Optional<List<Data_DrctlyUseQntUsageRetv>> findByBillRetrieve(String svcContId);
	@Query(value = "SELECT * FROM drctly_use_qnt_usage_retv  WHERE svc_cont_id = :svcContId and retv_st_dt =:retvStDt and sbscr_no=:sbscrNo", nativeQuery = true)
	public Optional<List<Data_DrctlyUseQntUsageRetv>> findByBillRetrieve(@Param("svcContId") String svcContId,
            @Param("retvStDt") String retvStDt,@Param("sbscrNo") String sbscrNo);
}
