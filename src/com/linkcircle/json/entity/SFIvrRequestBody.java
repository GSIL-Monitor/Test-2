package com.linkcircle.json.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SFIvrRequestBody {
	private String displayNum;
	private String calledNum;
	private String serviceKey;
	private String mediaContent;
	private String numCode;
	private String mediaPath;
	
	
	public String getMediaPath() {
		return mediaPath;
	}

	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

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

	public String getServiceKey() {
		return serviceKey;
	}

	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
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

	@Override
	public String toString() {
		return "SFIvrRequestBody [displayNum=" + displayNum + ", calledNum=" + calledNum + ", serviceKey=" + serviceKey
				+ ", mediaContent=" + mediaContent + ", numCode=" + numCode + "]";
	}
	
	

}
