package com.digitel.adminvas.webService.adomain;

public class BasicTariff {
	
	private float amount;
	private String trafitt;
	private boolean valid;
	
	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public String getTrafitt() {
		return trafitt;
	}
	
	public void setTrafitt(String trafitt) {
		this.trafitt = trafitt;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
