package com.garage.usagedata.remote.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Data_DrctlyUseQntMyOllehListRetv implements Serializable {

	private static final long serialVersionUID = 1L;

	private String perdFlag;
	private String toongFlag;
	private String dayFreeYn;
	private List<Data_DrctlyUseQntFreeRetv> drctlyUseQntFreeRetvOut;
	private List<Data_DrctlyUseQntUsageRetv> drctlyUseQntUsageRetvOut;
	
	protected Data_DrctlyUseQntMyOllehListRetv() {
	}

	
}
