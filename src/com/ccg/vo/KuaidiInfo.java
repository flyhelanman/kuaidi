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
	private String signname;
	private String signedtime;
	private String departure;
	private String addressee;
	private String destination;
	private String pickuptime;
	
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
	public String getSignname() {
		return signname;
	}
	public void setSignname(String signname) {
		this.signname = signname;
	}
	public String getSignedtime() {
		return signedtime;
	}
	public void setSignedtime(String signedtime) {
		this.signedtime = signedtime;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getPickuptime() {
		return pickuptime;
	}
	public void setPickuptime(String pickuptime) {
		this.pickuptime = pickuptime;
	}
}
