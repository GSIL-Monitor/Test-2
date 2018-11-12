/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: CallStatusRecord.java 
 * @Prject: CTDNOTICE
 * @Package: com.linkcircle.jd.json.entity 
 * @Description: TODO
 * @author: awbsheng@gmail.com   
 * @date: 2017年8月16日 下午6:10:52 
 * @version: V1.0   
 */
package com.linkcircle.json.entity;

/** 
 * @ClassName: CallStatusRecord 
 * @Description: TODO
 * @author: wbsheng@gmail.com
 * @date: 2017年8月16日 下午6:10:52  
 */
public class CallStatusRecord {
	private CallStatusRecordBody body;
	private Header header;
	public CallStatusRecordBody getBody() {
		return body;
	}
	public void setBody(CallStatusRecordBody body) {
		this.body = body;
	}
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	
}
