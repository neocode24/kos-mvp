package com.garage.usagedata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.garage.usagedata.bean.Data_DataTotDtlRetvProdNm;
import com.garage.usagedata.bean.PK_DataTotDtlRetvProdNm;

public interface DataTotDtlRetvProdNmRepository extends CrudRepository<Data_DataTotDtlRetvProdNm, PK_DataTotDtlRetvProdNm> {
	@Query(value = "SELECT * FROM data_tot_dtl_retv_prod_nm WHERE svc_cont_id = ?1 and rqt_date =?2 and mdn=?3", nativeQuery = true)
	public Optional<List<Data_DataTotDtlRetvProdNm>> findByTotDtl(@Param("svcContId") String svcContId,
            @Param("rqt_date") String rqt_date,@Param("mdn") String mdn);
}