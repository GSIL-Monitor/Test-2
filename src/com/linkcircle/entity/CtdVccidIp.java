package com.linkcircle.entity;

public class CtdVccidIp {
	private Integer id;
	private String vccid;
	private String ip;
	private String remark;
	private String dataSource;


	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVccid() {
		return vccid;
	}
	public void setVccid(String vccid) {
		this.vccid = vccid == null ? null : vccid.trim();
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}
