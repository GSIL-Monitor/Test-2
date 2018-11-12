/**
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: PageInfo.java
 * @Prject: CTDService
 * @Package: com.linkcircle.ui.entity
 * @Description: TODO
 * @author: awbsheng@gmail.com
 * @date: 2017年8月23日 下午2:48:35
 * @version: V1.0
 */
package com.linkcircle.ui.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** 
 * @ClassName: PageInfo 
 * @Description: TODO
 * @author: wbsheng@gmail.com
 * @date: 2017年8月23日 下午2:48:35  
 */
@JsonInclude(Include.NON_NULL)
public class Pagination {
	private String dataSource;
	private Integer offset;
	private Integer limit;
	private Integer pageSize;
	private Integer pageNumber;
	private String vccid;
	private String servicekey;
	private String disPlayNum;
	private Integer status;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDisPlayNum() {
		return disPlayNum;
	}
	public void setDisPlayNum(String disPlayNum) {
		this.disPlayNum = disPlayNum;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getVccid() {
		return vccid;
	}
	public void setVccid(String vccid) {
		this.vccid = vccid;
	}
	public String getServicekey() {
		return servicekey;
	}
	public void setServicekey(String servicekey) {
		this.servicekey = servicekey;
	}
	@Override
	public String toString() {
		return "Pagination [dataSource=" + dataSource + ", offset=" + offset + ", limit=" + limit + ", pageSize="
				+ pageSize + ", pageNumber=" + pageNumber + ", vccid=" + vccid + ", servicekey=" + servicekey + "]";
	}
	
}
