package com.linkcircle.json.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class IvrRequest {
	private IvrRequestBody body;
	private Header header;

	public IvrRequestBody getBody() {
		return body;
	}

	public void setBody(IvrRequestBody body) {
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
