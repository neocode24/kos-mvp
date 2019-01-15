package com.garage.usagedata.bean;

import java.io.Serializable;
import java.util.Optional;
import java.util.List;

import com.garage.usagedata.bean.Data_DrctlyUseQntFreeRetv;
import com.garage.usagedata.bean.Data_DrctlyUseQntUsageRetv;


public class Data_DrctlyUseQntMyOllehListRetv implements Serializable {

	private static final long serialVersionUID = 1L;

	private String perdFlag;
	private String toongFlag;
	private String dayFreeYn;
	private Optional<List<Data_DrctlyUseQntFreeRetv>> freeData;
	private Optional<List<Data_DrctlyUseQntUsageRetv>> usageData;
	
	public Data_DrctlyUseQntMyOllehListRetv(Optional<List<Data_DrctlyUseQntFreeRetv>> freeData,Optional<List<Data_DrctlyUseQntUsageRetv>> usageData) {
		this.freeData = freeData;
		this.usageData = usageData;
	}

	public String getPerdFlag() {
		return perdFlag;
	}


	public void setPerdFlag(String perdFlag) {
		this.perdFlag = perdFlag;
	}


	public String getToongFlag() {
		return toongFlag;
	}


	public void setToongFlag(String toongFlag) {
		this.toongFlag = toongFlag;
	}


	public String getDayFreeYn() {
		return dayFreeYn;
	}


	public void setDayFreeYn(String dayFreeYn) {
		this.dayFreeYn = dayFreeYn;
	}

	public Optional<List<Data_DrctlyUseQntFreeRetv>> getDrctlyUseQntFreeRetvOut() {
		return freeData;
	}
	
	public Optional<List<Data_DrctlyUseQntUsageRetv>> getDrctlyUseQntUsageRetvOut() {
		return usageData;
	}
	
}
