package com.linkcircle.entity;

public class CtdDisplayNum {
    private Integer id;
    private Integer status;

    private String displaynum;

    private String areacode;

    private String createtime;

    private String updatetime;

    private String vccid;

    private String servicekey;
    
    private String dataSource;

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

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

    public String getDisplaynum() {
        return displaynum;
    }

    public void setDisplaynum(String displaynum) {
        this.displaynum = displaynum == null ? null : displaynum.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
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
}