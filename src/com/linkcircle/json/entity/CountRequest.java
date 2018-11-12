package com.linkcircle.json.entity;

public class CountRequest {
	private CountRequestBody body;
	private Header header;

	public CountRequestBody getBody() {
		return body;
	}

	public void setBody(CountRequestBody body) {
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
		return "CountRequest [body=" + body + ", header=" + header + "]";
	}

}
