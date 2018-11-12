package com.linkcircle.entity;

import java.io.Serializable;

/**
 * @Title: VccidUrl
 * @Description: 
 * @author awbsheng@gmail.com
 * @date   2017年6月7日上午9:37:30
 */
public class VccIdUrl implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String vccId;
	private String servicekey;
	private int type;
	private String url;
	private String createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVccId() {
		return vccId;
	}
	public void setVccId(String vccId) {
		this.vccId = vccId;
	}
	public String getServicekey() {
		return servicekey;
	}
	public void setServicekey(String servicekey) {
		this.servicekey = servicekey;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "VccidUrl [id=" + id + ", vccId=" + vccId + ", servicekey=" + servicekey + ", type=" + type + ", url="
				+ url + ", createTime=" + createTime + "]";
	}
	
}
