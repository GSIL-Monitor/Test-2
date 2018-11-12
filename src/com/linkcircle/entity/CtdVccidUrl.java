package com.linkcircle.entity;

import java.io.Serializable;

public class CtdVccidUrl implements Serializable{
    /**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String vccid;

    private String servicekey;

    private Integer type;

    private String url;

    private String createtime;
    
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

    public String getServicekey() {
        return servicekey;
    }

    public void setServicekey(String servicekey) {
        this.servicekey = servicekey == null ? null : servicekey.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

	@Override
	public String toString() {
		return "CtdVccidUrl [id=" + id + ", vccid=" + vccid + ", servicekey=" + servicekey + ", type=" + type + ", url="
				+ url + ", createtime=" + createtime + ", dataSource=" + dataSource + "]";
	}
    
}