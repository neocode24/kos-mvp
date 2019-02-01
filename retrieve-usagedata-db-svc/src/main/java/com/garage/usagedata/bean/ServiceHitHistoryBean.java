package com.garage.usagedata.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="serviceHitHistory")
@Getter
@Setter
@ToString
public class ServiceHitHistoryBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String ipAddr;
	
	@Column
	private String uriInfo;
	
	@Column
	private String svcContId;
	
	@Column
	private String svcNo;
	
	@Column
	private String prodId;
	
	@Column
	private String succYn;
	
	@Column
	private Date createDate;
	
	@Builder
	public ServiceHitHistoryBean(String ipAddr, String uriInfo, String svcContId, String svcNo, String prodId, String succYn) {
		this();
		this.ipAddr = ipAddr;
		this.uriInfo = uriInfo;
		this.svcContId = svcContId;
		this.svcNo = svcNo;
		this.prodId = prodId;
		this.succYn = succYn;
	}
	
	public ServiceHitHistoryBean() {
		this.createDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
	}
	
	
}
