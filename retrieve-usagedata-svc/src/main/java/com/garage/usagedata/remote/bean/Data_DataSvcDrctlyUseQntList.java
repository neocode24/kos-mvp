package com.garage.usagedata.remote.bean;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Data_DataSvcDrctlyUseQntList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String svcContId;
	
	private String retvDt;
	
	private String prodEfctStDate;
	
	private String prodEfctFnsDate;
	
	private String prodId;
	
	private String prodNm;
	
	private String ntnlOutnetVcTlkQnt;
	
	private String billMidCtgCd;
	
	private String billMidCtgNm;
	
	private String totUseQnt;
	
	private String nnRatUseQnt;
	
	private String ratUseQnt;
	
	private String ratAmt;
	
	private String svcTarif;
	
	private String bigiDiv;
	
	protected Data_DataSvcDrctlyUseQntList() {
	}


	@Builder
	public Data_DataSvcDrctlyUseQntList(String svcContId, String retvDt, String prodEfctStDate,
											String prodEfctFnsDate, String prodId, String prodNm, String ntnlOutnetVcTlkQnt,
											String billMidCtgCd, String billMidCtgNm, String totUseQnt, String nnRatUseQnt, 
											String ratUseQnt, String ratAmt, String svcTarif, String bigiDiv) {

		this.svcContId = svcContId;
		this.retvDt = retvDt;
		this.prodEfctStDate = prodEfctStDate;
		this.prodEfctFnsDate = prodEfctFnsDate;
		this.prodId = prodId;
		this.prodNm = prodNm;
		this.ntnlOutnetVcTlkQnt = ntnlOutnetVcTlkQnt;
		this.billMidCtgCd = billMidCtgCd;
		this.billMidCtgNm = billMidCtgNm;
		this.totUseQnt = totUseQnt;
		this.nnRatUseQnt = nnRatUseQnt;
		this.ratUseQnt = ratUseQnt;
		this.ratAmt = ratAmt;
		this.svcTarif = svcTarif;
		this.bigiDiv = bigiDiv;
	}
	
}
