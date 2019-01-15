package com.garage.usagedata.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(PK_DrctlyUseQntFreeRetv.class)
@Table(name = "drctlyUseQntFreeRetv")
public class Data_DrctlyUseQntFreeRetv implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name = "svcContId")
	private String svcContId;
	
	@Id
	@Column(name = "retvStDt")
	private String retvStDt;
	
	@Id
	@Column(name = "sbscrNo")
	private String sbscrNo;
	
	@Id
	@Column(name = "unitSvcGroupCd")
	private String unitSvcGroupCd;

	@Column(name = "typeInd")
	private String typeInd;
		
	@Column(name = "scrnInd")
	private String scrnInd;
	
	@Column(name = "prodId")
	private String prodId;
	
	@Column(name = "unitSvcGroupHnglNm")
	private String unitSvcGroupHnglNm;
	
	@Column(name = "perd")
	private String perd;
	
	@Column(name = "prodTypeCd")
	private String prodTypeCd;
	
	@Column(name = "freeCfwdYn")
	private String freeCfwdYn;
	
	@Column(name = "unitSvcGroupEngNm")
	private String unitSvcGroupEngNm;
	
	@Column(name = "lastTlkTod")
	private String lastTlkTod;
	
	@Column(name = "cfwdFreeQnt")
	private String cfwdFreeQnt;
	
	@Column(name = "totFreeQnt")
	private String totFreeQnt;
	
	@Column(name = "freeUseQnt")
	private String freeUseQnt;
	
	@Column(name = "tmonFreeQnt")
	private String tmonFreeQnt;
	
	
	protected Data_DrctlyUseQntFreeRetv() {
	}
	
	
	public String getSvcContId() {
		return svcContId;
	}

	public void setSvcContId(String svcContId) {
		this.svcContId = svcContId;
	}

	public String getRetvStDt() {
		return retvStDt;
	}

	public void setRetvStDt(String retvStDt) {
		this.retvStDt = retvStDt;
	}

	public String getSbscrNo() {
		return sbscrNo;
	}

	public void setSbscrNo(String sbscrNo) {
		this.sbscrNo = sbscrNo;
	}

	public String getUnitSvcGroupCd() {
		return unitSvcGroupCd;
	}

	public void setUnitSvcGroupCd(String unitSvcGroupCd) {
		this.unitSvcGroupCd = unitSvcGroupCd;
	}

	public String getScrnInd() {
		return scrnInd;
	}

	public void setScrnInd(String scrnInd) {
		this.scrnInd = scrnInd;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getTypeInd() {
		return typeInd;
	}

	public void setTypeInd(String typeInd) {
		this.typeInd = typeInd;
	}

	public String getUnitSvcGroupHnglNm() {
		return unitSvcGroupHnglNm;
	}

	public void setUnitSvcGroupHnglNm(String unitSvcGroupHnglNm) {
		this.unitSvcGroupHnglNm = unitSvcGroupHnglNm;
	}

	public String getPerd() {
		return perd;
	}

	public void setPerd(String perd) {
		this.perd = perd;
	}

	public String getProdTypeCd() {
		return prodTypeCd;
	}

	public void setProdTypeCd(String prodTypeCd) {
		this.prodTypeCd = prodTypeCd;
	}

	public String getFreeCfwdYn() {
		return freeCfwdYn;
	}

	public void setFreeCfwdYn(String freeCfwdYn) {
		this.freeCfwdYn = freeCfwdYn;
	}

	public String getUnitSvcGroupEngNm() {
		return unitSvcGroupEngNm;
	}

	public void setUnitSvcGroupEngNm(String unitSvcGroupEngNm) {
		this.unitSvcGroupEngNm = unitSvcGroupEngNm;
	}

	public String getLastTlkTod() {
		return lastTlkTod;
	}

	public void setLastTlkTod(String lastTlkTod) {
		this.lastTlkTod = lastTlkTod;
	}

	public String getCfwdFreeQnt() {
		return cfwdFreeQnt;
	}

	public void setCfwdFreeQnt(String cfwdFreeQnt) {
		this.cfwdFreeQnt = cfwdFreeQnt;
	}

	public String getTotFreeQnt() {
		return totFreeQnt;
	}

	public void setTotFreeQnt(String totFreeQnt) {
		this.totFreeQnt = totFreeQnt;
	}

	public String getFreeUseQnt() {
		return freeUseQnt;
	}

	public void setFreeUseQnt(String freeUseQnt) {
		this.freeUseQnt = freeUseQnt;
	}
	public String getTmonFreeQnt() {
		return tmonFreeQnt;
	}

	public void setTmonFreeQnt(String tmonFreeQnt) {
		this.tmonFreeQnt = tmonFreeQnt;
	}
	
	public Object getBillRetrieve(String svcContId, String retvStDt,String sbscrNo) {
		return new Data_DrctlyUseQntFreeRetv();
	}

}
