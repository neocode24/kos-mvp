package com.garage.usagedata.bean;

import java.io.Serializable;

public class PK_DrctlyUseQntFreeRetv implements Serializable {

	private static final long serialVersionUID = 1L;

	private String svcContId;
	
	private String retvStDt;
	
	private String sbscrNo;
	
	private String unitSvcGroupCd;
	
	public PK_DrctlyUseQntFreeRetv() {
		
	}
	
	public PK_DrctlyUseQntFreeRetv(String svcContId, String retvStDt, String sbscrNo,String unitSvcGroupCd) {
		this.svcContId = svcContId;
		this.retvStDt = retvStDt;
		this.sbscrNo = sbscrNo;
		this.unitSvcGroupCd=unitSvcGroupCd;
	}
	
}