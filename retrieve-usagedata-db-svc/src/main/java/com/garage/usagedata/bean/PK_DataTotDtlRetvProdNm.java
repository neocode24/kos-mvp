package com.garage.usagedata.bean;

import java.io.Serializable;

public class PK_DataTotDtlRetvProdNm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String svcContId;
	
	private String rqtDate;

	
	public PK_DataTotDtlRetvProdNm() {
		
	}
	
	public PK_DataTotDtlRetvProdNm(String svcContId, String rqtDate, String mdn) {
		this.svcContId = svcContId;
		this.rqtDate = rqtDate;
	}
	
}