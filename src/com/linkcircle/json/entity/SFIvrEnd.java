package com.linkcircle.json.entity;


public class SFIvrEnd {
	private SFIVREndRequestBody body;
	private Header header;

	public SFIVREndRequestBody getBody() {
		return body;
	}

	public void setBody(SFIVREndRequestBody body) {
		this.body = body;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	@Override
	public String toString() {
		return "IvrEnd [body=" + body + ", header=" + header + "]";
	}

}
