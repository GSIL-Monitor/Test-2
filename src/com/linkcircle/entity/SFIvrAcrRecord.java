package com.linkcircle.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author youngder
 * @Description 顺丰智能问卷话单实体类
 */
//xml转实体类注解
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ctc")
public class SFIvrAcrRecord {
    private String serviceName;
    private String callId;
    private String messageId;
    //被叫显示号码【主叫号码】
    private String calledDisplayNum;
    //被叫号码
    private String calledNum;
    private String calledStreamNo;
    //通话开始时间
    private String callStartTime;
    //响铃时间
    private String callRingTime;
    //接通时间
    private String callAnswerTime;
    //通话结束时间
    private String callEndTime;
    //通话时长
    private String calledDuration;
    //按键收号
    private String dtmfKey;
    private String calledRelCause;
    private String calledOriRescode;
    private String calledRelReason;
    
    
	public String getCalledDuration() {
		return calledDuration;
	}
	public void setCalledDuration(String calledDuration) {
		this.calledDuration = calledDuration;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getCallId() {
		return callId;
	}
	public void setCallId(String callId) {
		this.callId = callId;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getCalledDisplayNum() {
		return calledDisplayNum;
	}
	public void setCalledDisplayNum(String calledDisplayNum) {
		this.calledDisplayNum = calledDisplayNum;
	}
	public String getCalledNum() {
		return calledNum;
	}
	public void setCalledNum(String calledNum) {
		this.calledNum = calledNum;
	}
	public String getCalledStreamNo() {
		return calledStreamNo;
	}
	public void setCalledStreamNo(String calledStreamNo) {
		this.calledStreamNo = calledStreamNo;
	}
	public String getCallStartTime() {
		return callStartTime;
	}
	public void setCallStartTime(String callStartTime) {
		this.callStartTime = callStartTime;
	}
	public String getCallRingTime() {
		return callRingTime;
	}
	public void setCallRingTime(String callRingTime) {
		this.callRingTime = callRingTime;
	}
	public String getCallAnswerTime() {
		return callAnswerTime;
	}
	public void setCallAnswerTime(String callAnswerTime) {
		this.callAnswerTime = callAnswerTime;
	}
	public String getCallEndTime() {
		return callEndTime;
	}
	public void setCallEndTime(String callEndTime) {
		this.callEndTime = callEndTime;
	}
	public String getDtmfKey() {
		return dtmfKey;
	}
	public void setDtmfKey(String dtmfKey) {
		this.dtmfKey = dtmfKey;
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
	public String getCalledRelReason() {
		return calledRelReason;
	}
	public void setCalledRelReason(String calledRelReason) {
		this.calledRelReason = calledRelReason;
	}
	public SFIvrAcrRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SFIvrAcrRecord(String serviceName, String callId, String messageId, String calledDisplayNum,
			String calledNum, String calledStreamNo, String callStartTime, String callRingTime, String callAnswerTime,
			String callEndTime, String dtmfKey, String calledRelCause, String calledOriRescode,
			String calledRelReason) {
		super();
		this.serviceName = serviceName;
		this.callId = callId;
		this.messageId = messageId;
		this.calledDisplayNum = calledDisplayNum;
		this.calledNum = calledNum;
		this.calledStreamNo = calledStreamNo;
		this.callStartTime = callStartTime;
		this.callRingTime = callRingTime;
		this.callAnswerTime = callAnswerTime;
		this.callEndTime = callEndTime;
		this.dtmfKey = dtmfKey;
		this.calledRelCause = calledRelCause;
		this.calledOriRescode = calledOriRescode;
		this.calledRelReason = calledRelReason;
	}
	@Override
	public String toString() {
		return "SFIvrAcrRecord [serviceName=" + serviceName + ", callId=" + callId
				+ ", messageId=" + messageId + ", calledDisplayNum=" + calledDisplayNum + ", calledNum=" + calledNum
				+ ", calledStreamNo=" + calledStreamNo + ", callStartTime=" + callStartTime + ", callRingTime="
				+ callRingTime + ", callAnswerTime=" + callAnswerTime + ", callEndTime=" + callEndTime + ", dtmfKey="
				+ dtmfKey + ", calledRelCause=" + calledRelCause + ", calledOriRescode=" + calledOriRescode
				+ ", calledRelReason=" + calledRelReason + "]";
	}
    
}