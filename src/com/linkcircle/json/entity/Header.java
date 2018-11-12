package com.linkcircle.json.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Header {
	private String serviceName;
	private String messageId;
	private String vccId;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getVccId() {
		return vccId;
	}

	public void setVccId(String vccId) {
		this.vccId = vccId;
	}

	@Override
	public String toString() {
		return "RequestHeader [serviceName=" + serviceName + ", messagesId=" + messageId + ", vccId=" + vccId + "]";
	}

	public Header(String serviceName, String messageId, String vccId) {
		super();
		this.serviceName = serviceName;
		this.messageId = messageId;
		this.vccId = vccId;
	}

	public Header() {
		super();
	}

	public static Header header(String serviceName, String messageId) {
		return new Header(serviceName, messageId, null);
	}

}
