package com.linkcircle.json.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SFIvrRequest {
	private SFIvrRequestBody body;
	private Header header;

	public SFIvrRequestBody getBody() {
		return body;
	}

	public void setBody(SFIvrRequestBody body) {
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
		return "IvrRequest [body=" + body + ", header=" + header + "]";
	}
}
