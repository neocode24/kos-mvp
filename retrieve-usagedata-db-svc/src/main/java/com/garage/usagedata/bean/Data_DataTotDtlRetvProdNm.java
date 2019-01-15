package com.garage.usagedata.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@IdClass(PK_DataTotDtlRetvProdNm.class)
@Table(name = "dataTotDtlRetvProdNm")
@Getter
@Setter
@ToString
public class Data_DataTotDtlRetvProdNm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "svcContId")
	private String svcContId;
	
	@Id
	@Column(name = "rqtDate")
	private String rqtDate;
	
	@Id
	@Column(name = "mdn")
	private String mdn;
	
	@Id
	@Column(name = "svcCd")
	private String svcCd;
	
	@Column(name = "prodNm")
	private String prodNm;
	
	@Column(name = "prodSeq")
	private String prodSeq;
	
	@Column(name = "efctStDate")
	private String efctStDate;
	
	@Column(name = "efctFnsDate")
	private String efctFnsDate;
	
	
	@Column(name = "tmonPrvQnt")
	private String tmonPrvQnt;
	
	@Column(name = "cfwdPrvQnt")
	private String cfwdPrvQnt;
	
	@Column(name = "useQnt")
	private String useQnt;
	
	protected Data_DataTotDtlRetvProdNm() {
	}

	
}
