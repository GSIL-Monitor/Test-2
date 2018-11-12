package com.linkcircle.json.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponBody {
	private String result;
	private String callId;
	private String reason;
	private String count;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCallId() {
		return callId;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public ResponBody(String result, String callId, String reason, String count) {
		super();
		this.result = result;
		this.callId = callId;
		this.reason = reason;
		this.count = count;
	}

	public ResponBody() {
		super();
	}

	public ResponBody(String callId, String count) {
		super();
		this.callId = callId;
		this.count = count;
	}

	public static ResponBody success() {
		return new ResponBody("0000", null, "succ", null);
	}
	
	public static ResponBody success(String msg) {
		return new ResponBody("0000", null, msg, null);
	}
	public static ResponBody success(String msg,String callId) {
		return new ResponBody("0000", callId, msg, null);
	}

	public static ResponBody error(String msg) {
		return new ResponBody("0001", null, msg, null);
	}
	public static ResponBody error(String code,String msg) {
		return new ResponBody(code, null, msg, null);
	}
}
