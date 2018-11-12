/**
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: HttpResponse.java
 * @Prject: CTDNOTICE
 * @Package: com.linkcircle.json.entity
 * @Description: TODO
 * @author: awbsheng@gmail.com
 * @date: 2017年7月14日 下午2:52:12
 * @version: V1.0
 */
package com.linkcircle.json.entity;

/** 
 * @ClassName: HttpResponse 
 * @Description: TODO
 * @author: wbsheng@gmail.com
 * @date: 2017年7月14日 下午2:52:12  
 */
public class HttpResponse {
	private int status;
	private String result;
	private String massage;

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	@Override
	public String toString() {
		return "HttpResponse [status=" + status + ", result=" + result + ", massage=" + massage + "]";
	}
	
}
