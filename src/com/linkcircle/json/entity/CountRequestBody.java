package com.linkcircle.json.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CountRequestBody {
	private String bussinessId;
	private String serviceKey;
	private String playMode;


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
}
