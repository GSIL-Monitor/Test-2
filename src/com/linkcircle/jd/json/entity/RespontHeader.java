package com.linkcircle.jd.json.entity;

public class RespontHeader {
	private String appId;
	private String serviceName;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "RespontHeader [appId=" + appId + ", serviceName=" + serviceName + "]";
	}

}
