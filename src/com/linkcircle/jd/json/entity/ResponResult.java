package com.linkcircle.jd.json.entity;

public class ResponResult {
	private ResultHeader header;

	public ResultHeader getHeader() {
		return header;
	}

	public void setHeader(ResultHeader header) {
		this.header = header;
	}

	@Override
	public String toString() {
		return "ResponResult [header=" + header + "]";
	}

}
