/**
 * * * * Created on Feb 08, 2011 by Jamil
 *
 * Copyright (c) 2006 aurionPro Solutions Ltd.
 * Unit no. 404, 4th Floor, Winchester Building Hiranandani Garden ,
 * Powai, Mumbai - 400076.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of 
 * aurionPro Solutions Ltd. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with aurionPro Solutions Ltd.
 */
package com.sd.training.swift.tag;

/**
 *101. This gives the Transaction Reference.
 *This class give you Account identification 
 * @author Jmail
 *
 */

public class Tag20 extends AbstractTag {
	
	
	/** Message Format  16x   
	 */
	
	/** 
	 * 
	 * Example : TRANSREF1 
	 */
	
	private String txnRefId;
    
	public Tag20() {
		super();
	}
	public Tag20(String value) {
		super(value);
	}

	
	public void splitTagValue(){
		txnRefId = tagValue;
	}


	public String getTxnRefId() {
		return txnRefId;
	}


	public void setTxnRefId(String txnRefId) {
		this.txnRefId = txnRefId;
	}
	
   @Override
   	public String getTagValue() {
	if(tagValue == null){
		if(txnRefId == null)
		{
			throw new TagException("Tag 20 : Transaction Reference id is mandatory");
		}
	}
	tagValue = txnRefId;
	return tagValue;
   }
   
}