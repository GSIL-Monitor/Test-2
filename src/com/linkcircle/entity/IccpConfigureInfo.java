package com.linkcircle.entity;
/**
 * 
 * @author youngder 2017-12-18 15:34
 * ICCP-SN信息
 */
public class IccpConfigureInfo {
    private Integer id;
    private String  ip;
    private Integer port;
    private String password;
    private String state;
    private String remark;
    private String source;
    
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public IccpConfigureInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public IccpConfigureInfo(String ip, Integer port, String password, String state, String remark, String source) {
		super();
		this.ip = ip;
		this.port = port;
		this.password = password;
		this.state = state;
		this.remark = remark;
		this.source = source;
	}
	@Override	
	public String toString() {
		return "IccpConfigureInfo [id=" + id + ", ip=" + ip + ", port=" + port + ", password=" + password + ", state="
				+ state + ", remark=" + remark + "]";
	}
	
}