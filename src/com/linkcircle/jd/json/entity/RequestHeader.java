package com.linkcircle.jd.json.entity;

public class RequestHeader {
	private String vccId;
	private String serviceName;
	public String getVccId() {
		return vccId;
	}
	public void setVccId(String vccId) {
		this.vccId = vccId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	@Override
	public String toString() {
		return "RequestHeader [vccId=" + vccId + ", serviceName=" + serviceName + "]";
	}
	
}
