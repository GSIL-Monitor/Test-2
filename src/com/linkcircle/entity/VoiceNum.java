package com.linkcircle.entity;

import java.io.Serializable;

/**
 * @Title: VoiceNum
 * @Description:
 * @author awbsheng@gmail.com
 * @date 2017年6月7日上午9:40:22
 */
public class VoiceNum implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String vccId;
	private String serviceName;

	private String bussinessId;

	private String displayNum;

	private String serviceKey;

	private String playMode;

	private String welcomeIvrName;

	private String playMediaName;

	private String key1;

	private String key2;

	private String key3;

	private String createtime;

	private String updatetime;

	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVccId() {
		return vccId;
	}

	public void setVccId(String vccId) {
		this.vccId = vccId;
	}

	public String getBussinessId() {
		return bussinessId;
	}

	public void setBussinessId(String bussinessId) {
		this.bussinessId = bussinessId;
	}

	public String getDisplayNum() {
		return displayNum;
	}

	public void setDisplayNum(String displayNum) {
		this.displayNum = displayNum;
	}

	
	public String getServiceKey() {
		return serviceKey;
	}

	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}

	public String getPlayMode() {
		return playMode;
	}

	public void setPlayMode(String playMode) {
		this.playMode = playMode;
	}

	public String getWelcomeIvrName() {
		return welcomeIvrName;
	}

	public void setWelcomeIvrName(String welcomeIvrName) {
		this.welcomeIvrName = welcomeIvrName;
	}

	public String getPlayMediaName() {
		return playMediaName;
	}

	public void setPlayMediaName(String playMediaName) {
		this.playMediaName = playMediaName;
	}

	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getKey2() {
		return key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public String getKey3() {
		return key3;
	}

	public void setKey3(String key3) {
		this.key3 = key3;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "VoiceNum [vccId=" + vccId + ", serviceName=" + serviceName + ", bussinessId=" + bussinessId
				+ ", displayNum=" + displayNum + ", serviceKey=" + serviceKey + ", playMode=" + playMode
				+ ", welcomeIvrName=" + welcomeIvrName + ", playMediaName=" + playMediaName + ", key1=" + key1
				+ ", key2=" + key2 + ", key3=" + key3 + ", createtime=" + createtime + ", updatetime=" + updatetime
				+ ", remark=" + remark + "]";
	}

}
