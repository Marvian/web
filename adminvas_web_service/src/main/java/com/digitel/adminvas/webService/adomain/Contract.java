package com.digitel.adminvas.webService.adomain;

import java.sql.Date;

public class Contract {
	
	private String provider;
	private int percent;
	private Date requestDate;
	private Date firmDate;
	private Date lastChangeDate;
	private Date expirationDate;
	private String type;
	
	
	
	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public int getPercent() {
		return percent;
	}
	
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	public Date getRequestDate() {
		return requestDate;
	}
	
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	public Date getFirmDate() {
		return firmDate;
	}
	
	public void setFirmDate(Date firmDate) {
		this.firmDate = firmDate;
	}
	
	public Date getLastChangeDate() {
		return lastChangeDate;
	}
	
	public void setLastChangeDate(Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
