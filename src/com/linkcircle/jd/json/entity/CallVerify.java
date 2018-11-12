package com.linkcircle.jd.json.entity;

public class CallVerify {
	private RequestHeader header;
	private CallVerifyBody body;

	public RequestHeader getHeader() {
		return header;
	}

	public void setHeader(RequestHeader header) {
		this.header = header;
	}

	public CallVerifyBody getBody() {
		return body;
	}

	public void setBody(CallVerifyBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "CallVerify [header=" + header + ", body=" + body + "]";
	}

}
