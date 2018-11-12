package com.linkcircle.json.entity;


public class IvrEnd {
	private IVREndRequestBody body;
	private Header header;

	public IVREndRequestBody getBody() {
		return body;
	}

	public void setBody(IVREndRequestBody body) {
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
