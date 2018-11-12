package com.linkcircle.jd.json.entity;

public class ResultBody {
	private String messageId;
	private String callId;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getCallId() {
		return callId;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}

	public ResultBody(String messageId, String callId) {
		super();
		this.messageId = messageId;
		this.callId = callId;
	}

	@Override
	public String toString() {
		return "ResultBody [messageId=" + messageId + ", callId=" + callId + "]";
	}

	public ResultBody() {
		super();
	}

}
