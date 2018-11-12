package com.linkcircle.jd.json.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class CallACRBody {
	private String messageId;
	private String serviceKey;
	private String serviceType;
	private String callId;
	private String calledNum;
	private String calledDisplayNumber;
	private String calledDuration;
	private String startCallTime;
	private String stopCallTime;
	private String calledRelCause;
	private String duration;
	private String costCount;
	private String calledRelReason;
	private String calledOriRescode;
	private String content;

	
	
	@JsonProperty("content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonProperty("calledRelReason")
	public String getCalledRelReason() {
		return calledRelReason;
	}

	public void setCalledRelReason(String calledRelReason) {
		this.calledRelReason = calledRelReason;
	}

	@JsonProperty("calledOriRescode")
	public String getCalledOriRescode() {
		return calledOriRescode;
	}

	public void setCalledOriRescode(String calledOriRescode) {
		this.calledOriRescode = calledOriRescode;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

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

	public String getCallId() {
		return callId;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}

	public String getCalledNum() {
		return calledNum;
	}

	public void setCalledNum(String calledNum) {
		this.calledNum = calledNum;
	}

	public String getCalledDisplayNumber() {
		return calledDisplayNumber;
	}

	public void setCalledDisplayNumber(String calledDisplayNumber) {
		this.calledDisplayNumber = calledDisplayNumber;
	}

	public String getCalledDuration() {
		return calledDuration;
	}

	public void setCalledDuration(String calledDuration) {
		this.calledDuration = calledDuration;
	}

	public String getStartCallTime() {
		return startCallTime;
	}

	public void setStartCallTime(String startCallTime) {
		this.startCallTime = startCallTime;
	}

	public String getStopCallTime() {
		return stopCallTime;
	}

	public void setStopCallTime(String stopCallTime) {
		this.stopCallTime = stopCallTime;
	}

	public String getCalledRelCause() {
		return calledRelCause;
	}

	public void setCalledRelCause(String calledRelCause) {
		this.calledRelCause = calledRelCause;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCostCount() {
		return costCount;
	}

	public void setCostCount(String costCount) {
		this.costCount = costCount;
	}

	@Override
	public String toString() {
		return "CallACRBody [messageId=" + messageId + ", serviceKey=" + serviceKey + ", serviceType=" + serviceType
				+ ", callId=" + callId + ", calledNum=" + calledNum + ", calledDisplayNumber=" + calledDisplayNumber
				+ ", calledDuration=" + calledDuration + ", startCallTime=" + startCallTime + ", stopCallTime="
				+ stopCallTime + ", calledRelCause=" + calledRelCause + ", duration=" + duration + ", costCount="
				+ costCount + "]";
	}

}
