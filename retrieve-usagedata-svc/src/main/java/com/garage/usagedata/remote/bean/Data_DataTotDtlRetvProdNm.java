package com.garage.usagedata.remote.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Data_DataTotDtlRetvProdNm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String svcContId;
	
	private String rqtDate;
	
	private String mdn;
	
	private String svcCd;
	
	private String prodNm;
	
	private String prodSeq;
	
	private String efctStDate;
	
	private String efctFnsDate;
	
	private String tmonPrvQnt;
	
	private String cfwdPrvQnt;
	
	private String useQnt;
	
	protected Data_DataTotDtlRetvProdNm() {
	}

	
}
