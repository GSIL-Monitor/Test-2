package com.linkcircle.json.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class IVREndRequestBody {
	private String serviceKey;
	private String playMode;
	private String callId;
	private String calledNum;
	private String calledDisplayNumber;
	private String calledStreamNo;
	private String startCalledTime;
	private String stopCalledTime;
	private String calledDuration;
	private String calledCost;
	private String calledRelCause;
	private String calledOriRescode;
	private String chargeNumber;
	private String calledRelReason;
	private String callOutTime;
	private String msServer;
	private String duration;
	private String costCount;
	private String vccId;
	private String mediaContent;
	private String eventType;
	private String receiveIVREventType;
	private Integer type;
	private Integer source;
	
	
	public String getCallOutTime() {
		return callOutTime;
	}

	public void setCallOutTime(String callOutTime) {
		this.callOutTime = callOutTime;
	}

	public static IVREndRequestBody setERTS(IVREndRequestBody body) {
		body.setEventType("receivePhoneRecordInfoPublish");
		body.setReceiveIVREventType("receiveCqtIvrEventType");
		body.setSource(1);
		body.setType(1);
		return body;
	}
	public static IVREndRequestBody setVipKidERTS(IVREndRequestBody body,Integer source,Integer type) {
		body.setEventType("receivePhoneRecordInfoPublish");
		body.setReceiveIVREventType("receiveCqtIvrEventType");
		body.setSource(source);
		body.setType(type);
		return body;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getReceiveIVREventType() {
		return receiveIVREventType;
	}

	public void setReceiveIVREventType(String receiveIVREventType) {
		this.receiveIVREventType = receiveIVREventType;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getVccId() {
		return vccId;
	}

	public void setVccId(String vccId) {
		this.vccId = vccId;
	}

	public String getMediaContent() {
		return mediaContent;
	}

	public void setMediaContent(String mediaContent) {
		this.mediaContent = mediaContent;
	}

	public String getServiceKey() {
		return serviceKey;
	}

	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}


	public String getPlayMode() {
		return playMode;
	}

	public void setPlayMode(String playMode) {
		this.playMode = playMode;
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

	public String getCalledStreamNo() {
		return calledStreamNo;
	}

	public void setCalledStreamNo(String calledStreamNo) {
		this.calledStreamNo = calledStreamNo;
	}

	public String getStartCalledTime() {
		return startCalledTime;
	}

	public void setStartCalledTime(String startCalledTime) {
		this.startCalledTime = startCalledTime;
	}

	public String getStopCalledTime() {
		return stopCalledTime;
	}

	public void setStopCalledTime(String stopCalledTime) {
		this.stopCalledTime = stopCalledTime;
	}

	public String getCalledDuration() {
		return calledDuration;
	}

	public void setCalledDuration(String calledDuration) {
		this.calledDuration = calledDuration;
	}

	public String getCalledCost() {
		return calledCost;
	}

	public void setCalledCost(String calledCost) {
		this.calledCost = calledCost;
	}

	public String getCalledRelCause() {
		return calledRelCause;
	}

	public void setCalledRelCause(String calledRelCause) {
		this.calledRelCause = calledRelCause;
	}

	public String getCalledOriRescode() {
		return calledOriRescode;
	}

	public void setCalledOriRescode(String calledOriRescode) {
		this.calledOriRescode = calledOriRescode;
	}

	public String getChargeNumber() {
		return chargeNumber;
	}

	public void setChargeNumber(String chargeNumber) {
		this.chargeNumber = chargeNumber;
	}

	public String getCalledRelReason() {
		return calledRelReason;
	}

	public void setCalledRelReason(String calledRelReason) {
		this.calledRelReason = calledRelReason;
	}

	public String getMsServer() {
		return msServer;
	}

	public void setMsServer(String msServer) {
		this.msServer = msServer;
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
		return "IVREndRequestBody [serviceKey=" + serviceKey + ", playMode=" + playMode + ", callId=" + callId
				+ ", calledNum=" + calledNum + ", calledDisplayNumber=" + calledDisplayNumber + ", calledStreamNo="
				+ calledStreamNo + ", startCalledTime=" + startCalledTime + ", stopCalledTime=" + stopCalledTime
				+ ", calledDuration=" + calledDuration + ", calledCost=" + calledCost + ", calledRelCause="
				+ calledRelCause + ", calledOriRescode=" + calledOriRescode + ", chargeNumber=" + chargeNumber
				+ ", calledRelReason=" + calledRelReason + ", msServer=" + msServer + ", duration=" + duration
				+ ", costCount=" + costCount + ", vccId=" + vccId + ", mediaContent=" + mediaContent + "]";
	}
}
