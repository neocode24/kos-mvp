/****************************************************************************************************
 * 
 *  Copyright ⓒ 2018 kt corp. All rights reserved.
 *
 *  This is a proprietary software of kt corp, and you may not use this file except in
 *  compliance with license agreement with kt corp. Any redistribution or use of this
 *  software, with or without modification shall be strictly prohibited without prior written
 *  approval of kt corp, and the copyright notice above does not evidence any actual or
 *  intended publication of such software.
 *
 *
 *****************************************************************************************************
 * date        Modifier Description
 *****************************************************************************************************
 * 2019. 3. 6. 82022961
 * 
 *****************************************************************************************************/
package com.ktds.cert.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 82022961
 * @Desction 
 */
@Getter
@Setter
@ToString
public class EchoBean {

	private String echoStr;
	
	protected EchoBean() {
		
	}
	
	@Builder
	public EchoBean(String echoStr) {
		this.echoStr = echoStr;
	}
}
