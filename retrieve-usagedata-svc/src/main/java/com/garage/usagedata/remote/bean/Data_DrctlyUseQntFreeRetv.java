package com.garage.usagedata.remote.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Data_DrctlyUseQntFreeRetv implements Serializable {

	private static final long serialVersionUID = 1L;
    
	private String svcContId;
	
	private String retvStDt;
	
	private String sbscrNo;
	
	private String unitSvcGroupCd;

	private String typeInd;
		
	private String scrnInd;
	
	private String prodId;
	
	private String unitSvcGroupHnglNm;
	
	private String perd;
	
	private String prodTypeCd;
	
	private String freeCfwdYn;
	
	private String unitSvcGroupEngNm;
	
	private String lastTlkTod;
	
	private String cfwdFreeQnt;
	
	private String totFreeQnt;
	
	private String freeUseQnt;
	
	private String tmonFreeQnt;
	
	
	protected Data_DrctlyUseQntFreeRetv() {
	}
	

}
