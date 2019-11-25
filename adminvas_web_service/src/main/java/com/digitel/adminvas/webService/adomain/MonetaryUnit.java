package com.digitel.adminvas.webService.adomain;

import java.sql.Date;

public class MonetaryUnit {
	
	private String name;
	private String notation;
	private Date validDate;
	private Date closingDate;
	private boolean valid;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNotation() {
		return notation;
	}
	
	public void setNotation(String notation) {
		this.notation = notation;
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
