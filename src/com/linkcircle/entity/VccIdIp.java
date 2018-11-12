package com.linkcircle.entity;

import java.io.Serializable;

/**
 * @Title: VccIdIp
 * @Description: 
 * @author awbsheng@gmail.com
 * @date   2017年6月7日上午9:38:57
 */
public class VccIdIp implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String vccId;
	private String ip;
	private String remark;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "VccIdIp [id=" + id + ", vccId=" + vccId + ", ip=" + ip + ", remark=" + remark + "]";
	}
}
