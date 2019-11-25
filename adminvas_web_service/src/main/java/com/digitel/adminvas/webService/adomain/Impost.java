package com.digitel.adminvas.webService.adomain;

import java.sql.Date;

public class Impost {
	
	private String name;
	private int percent;
	private Date validDate;
	private Date closingDate;
	private boolean valid;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPercent() {
		return percent;
	}
	
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	public Date getValidDate() {
		return validDate;
	}
	
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	
	public Date getClosingDate() {
		return closingDate;
	}
	
	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	

}
