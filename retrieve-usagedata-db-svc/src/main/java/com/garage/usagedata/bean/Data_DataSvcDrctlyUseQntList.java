package com.garage.usagedata.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@IdClass(PK_DataSvcDrctlyUseQntList.class)
@Table(name = "dataSvcDrctlyUseQntList")
@Getter
@Setter
@ToString
public class Data_DataSvcDrctlyUseQntList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "svcContId")
	private String svcContId;
	
	@Id
	@Column(name = "retvDt")
	private String retvDt;
	
	@Column(name = "prodEfctStDate")
	private String prodEfctStDate;
	
	@Column(name = "prodEfctFnsDate")
	private String prodEfctFnsDate;
	
	@Column(name = "prodId")
	private String prodId;
	
	@Column(name = "prodNm")
	private String prodNm;
	
	@Column(name = "ntnlOutnetVcTlkQnt")
	private String ntnlOutnetVcTlkQnt;
	
	@Column(name = "billMidCtgCd")
	private String billMidCtgCd;
	
	@Column(name = "billMidCtgNm")
	private String billMidCtgNm;
	
	@Column(name = "totUseQnt")
	private String totUseQnt;
	
	@Column(name = "nnRatUseQnt")
	private String nnRatUseQnt;
	
	@Column(name = "ratUseQnt")
	private String ratUseQnt;
	
	@Column(name = "ratAmt")
	private String ratAmt;
	
	@Column(name = "svcTarif")
	private String svcTarif;
	
	@Column(name = "bigiDiv")
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
