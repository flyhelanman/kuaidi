package com.ccg.vo;

import java.util.List;

public class KuaidiInfo {

	private String message;
	private String nu;
	private String ischeck;
	private String com;
	private String status;
	private String condition;
	private String state;
	private String updatetime;
	private String companytype;
	private String codenumber;
	
	public String getCodenumber() {
		return codenumber;
	}
	public void setCodenumber(String codenumber) {
		this.codenumber = codenumber;
	}
	private List<KuaidiInfoVo>data;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNu() {
		return nu;
	}
	public void setNu(String nu) {
		this.nu = nu;
	}
	public String getIscheck() {
		return ischeck;
	}
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<KuaidiInfoVo> getData() {
		return data;
	}
	public void setData(List<KuaidiInfoVo> data) {
		this.data = data;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getCompanytype() {
		return companytype;
	}
	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}
}
