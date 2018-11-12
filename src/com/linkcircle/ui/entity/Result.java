/**
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: Result.java
 * @Prject: CTDService
 * @Package: com.linkcircle.ui.entity
 * @Description: TODO
 * @author: awbsheng@gmail.com
 * @date: 2017年8月24日 下午5:46:41
 * @version: V1.0
 */
package com.linkcircle.ui.entity;

/** 
 * @ClassName: Result 
 * @Description: TODO
 * @author: wbsheng@gmail.com
 * @date: 2017年8月24日 下午5:46:41  
 */
public class Result {
	private Integer code;
	private String msg;

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Result(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public Result() {
		super();
	}
	
	public static Result getResult(Integer code, String msg) {
		return new Result(code, msg);
	}
}
