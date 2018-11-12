/**
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: CallStatusRecordBody.java
 * @Prject: CTDNOTICE
 * @Package: com.linkcircle.jd.json.entity
 * @Description: TODO
 * @author: awbsheng@gmail.com
 * @date: 2017年8月16日 下午6:10:35
 * @version: V1.0
 */
package com.linkcircle.jd.json.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** 
 * @ClassName: CallStatusRecordBody 
 * @Description: TODO
 * @author: wbsheng@gmail.com
 * @date: 2017年8月16日 下午6:10:35  
 */
@JsonInclude(Include.NON_NULL)
public class CallVoiceVerifyStatusRecord {
	private String timestamp;
	private String called;
	private String callId;
	private String userFlag;
	private String callStatus;
	private String errorCode;
	private String messageId;
	private String serviceKey;
	private String serviceType;
	private String caller;
	

	
	
	public String getServiceKey() {
		return serviceKey;
	}
	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getCaller() {
		return caller;
	}
	public void setCaller(String caller) {
		this.caller = caller;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getCalled() {
		return called;
	}
	public void setCalled(String called) {
		this.called = called;
	}
	public String getCallId() {
		return callId;
	}
	public void setCallId(String callId) {
		this.callId = callId;
	}
	public String getUserFlag() {
		return userFlag;
	}
	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}
	public String getCallStatus() {
		return callStatus;
	}
	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
}
