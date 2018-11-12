package com.linkcircle.jd.json.entity;

public class ResultHeader {
	private String resultCode;
	private String msg;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ResultHeader(String resultCode, String msg) {
		super();
		this.resultCode = resultCode;
		this.msg = msg;
	}

	public static ResultHeader success() {
		return new ResultHeader("0", "成功");
	}
	public static ResultHeader success(String msg) {
		return new ResultHeader("0", msg);
	}

	public static ResultHeader error() {
		return new ResultHeader("9", "失败");
	}

	public static ResultHeader error(String msg) {
		return new ResultHeader("9", msg);
	}

	public ResultHeader() {
		super();
	}

	@Override
	public String toString() {
		return "ResultHeader [resultCode=" + resultCode + ", msg=" + msg + "]";
	}
}
