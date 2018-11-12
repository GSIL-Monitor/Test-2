/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: XmlNumberEntity.java 
 * @Prject: CTDNOTICE
 * @Package: com.linkcircle.entity 
 * @Description: TODO
 * @author: awbsheng@gmail.com   
 * @date: 2017年9月14日 下午3:20:39 
 * @version: V1.0   
 */
package com.linkcircle.entity;

/** 
 * @ClassName: XmlNumberEntity 
 * @Description: TODO
 * @author: wbsheng@gmail.com
 * @date: 2017年9月14日 下午3:20:39  
 */
public class XmlNumberEntity {
	private String id;
	private String numbers;
	private String vccid;
	private String dataSource;
	
	
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumbers() {
		return numbers;
	}
	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}
	public String getVccid() {
		return vccid;
	}
	public void setVccid(String vccid) {
		this.vccid = vccid;
	}
	@Override
	public String toString() {
		return "XmlNumberEntity [id=" + id + ", numbers=" + numbers + ", vccid=" + vccid + "]";
	}
	
}
