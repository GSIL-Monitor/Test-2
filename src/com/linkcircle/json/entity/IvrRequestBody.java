package com.linkcircle.json.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class IvrRequestBody {
	private String displayNum;
	private String calledNum;
	private String bussinessId;
	private String serviceKey;
	private String playMode;
	private String welcomeIvrName;
	private String playMediaName;
	private String mediaContent;
	private String numCode;
	private String playTime;
	private String chargeNum;
	private String backMedia;

	public String getDisplayNum() {
		return displayNum;
	}

	public void setDisplayNum(String displayNum) {
		this.displayNum = displayNum;
	}

	public String getCalledNum() {
		return calledNum;
	}

	public void setCalledNum(String calledNum) {
		this.calledNum = calledNum;
	}

	

	public String getBussinessId() {
		return bussinessId;
	}

	public void setBussinessId(String bussinessId) {
		this.bussinessId = bussinessId;
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

	public String getWelcomeIvrName() {
		return welcomeIvrName;
	}

	public void setWelcomeIvrName(String welcomeIvrName) {
		this.welcomeIvrName = welcomeIvrName;
	}

	public String getPlayMediaName() {
		return playMediaName;
	}

	public void setPlayMediaName(String playMediaName) {
		this.playMediaName = playMediaName;
	}

	public String getMediaContent() {
		return mediaContent;
	}

	public void setMediaContent(String mediaContent) {
		this.mediaContent = mediaContent;
	}

	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getChargeNum() {
		return chargeNum;
	}

	public void setChargeNum(String chargeNum) {
		this.chargeNum = chargeNum;
	}

	public String getBackMedia() {
		return backMedia;
	}

	public void setBackMedia(String backMedia) {
		this.backMedia = backMedia;
	}

	@Override
	public String toString() {
		return "IvrRequestBody [displayNum=" + displayNum + ", calledNum=" + calledNum + ", bussinessId=" + bussinessId
				+ ", serviceKey=" + serviceKey + ", playMode=" + playMode + ", welcomeIvrName=" + welcomeIvrName
				+ ", playMediaName=" + playMediaName + ", mediaContent=" + mediaContent + ", numCode=" + numCode
				+ ", playTime=" + playTime + ", chargeNum=" + chargeNum + ", backMedia=" + backMedia + "]";
	}
}
