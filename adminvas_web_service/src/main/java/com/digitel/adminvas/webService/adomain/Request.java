package com.digitel.adminvas.webService.adomain;

import java.sql.Date;

public class Request {
	private String status;
	private Date dateRequest;
	private int cost;
	private int shortCode;
	private String typeRequest;
	private String provider;
	private String admin_finance;
	private String admin_segurity;
	private String admin_prepago;
	private String admin_postpago;
	private String admin_vas;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getDateRequest() {
		return dateRequest;
	}
	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getShortCode() {
		return shortCode;
	}
	
	public void setShortCode(int shortCode) {
		this.shortCode = shortCode;
	}
	
	public String getTypeRequest() {
		return typeRequest;
	}
	
	public void setTypeRequest(String typeRequest) {
		this.typeRequest = typeRequest;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getAdmin_finance() {
		return admin_finance;
	}
	
	public void setAdmin_finance(String admin_finance) {
		this.admin_finance = admin_finance;
	}
	
	public String getAdmin_segurity() {
		return admin_segurity;
	}
	
	public void setAdmin_segurity(String admin_segurity) {
		this.admin_segurity = admin_segurity;
	}
	
	public String getAdmin_prepago() {
		return admin_prepago;
	}
	
	public void setAdmin_prepago(String admin_prepago) {
		this.admin_prepago = admin_prepago;
	}
	
	public String getAdmin_postpago() {
		return admin_postpago;
	}
	
	public void setAdmin_postpago(String admin_postpago) {
		this.admin_postpago = admin_postpago;
	}
	
	public String getAdmin_vas() {
		return admin_vas;
	}
	
	public void setAdmin_vas(String admin_vas) {
		this.admin_vas = admin_vas;
	}
	
	
	
	
	

}
