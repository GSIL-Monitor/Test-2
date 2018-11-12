/**
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: TableResult.java
 * @Prject: CTDService
 * @Package: com.linkcircle.ui.entity
 * @Description: TODO
 * @author: awbsheng@gmail.com
 * @date: 2017年8月23日 下午3:01:27
 * @version: V1.0
 */
package com.linkcircle.ui.entity;

import java.util.List;

/** 
 * @ClassName: TableResult 
 * @Description: TODO
 * @author: wbsheng@gmail.com
 * @date: 2017年8月23日 下午3:01:27  
 */
public class TableResult {
	private Integer code;
	private String msg;
	private Long count;
	private List<?> data;
	private Long total;
	private List<?> rows;

	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
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
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "TableResult [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + ", total=" + total
				+ ", rows=" + rows + "]";
	}
	
}
