package com.garage.usagedata.remote.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Data_DrctlyUseQntUsageRetv implements Serializable {

	private static final long serialVersionUID = 1L;
    
	private String svcContId;
	
	private String retvStDt;
	
	private String sbscrNo;

	private String unitSvcGroupCd;

	private String scrnInd;
	
	private String prodId;
	
	private String typeInd;
	
	private String unitSvcGroupHnglNm;
	
	private String perd;
	
	private String prodTypeCd;
	
	private String freeCfwdYn;
	
	private String totUseQnt;
	
	private String ratUseQnt;
	
	private String lastTlkTod;
	
	private String ratAmt;
	

	protected Data_DrctlyUseQntUsageRetv() {
	}
	

}
