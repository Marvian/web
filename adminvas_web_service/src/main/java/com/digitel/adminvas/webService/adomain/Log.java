package com.digitel.adminvas.webService.adomain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "A_LOG")
public class Log implements Serializable{
	
	@Id
	@GeneratedValue(generator="SEQ_log", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_log", sequenceName = "SEQ_log", allocationSize = 1)
	@Column(name = "log_id")
	private int Id;
	
	@Column(name = "log_tipo_accion")
	private String action;
	
	@Column(name = "log_fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAction;
	
	@Column(name = "log_administrador")
	private String Admin;
	
	@Column(name = "log_mac")
	private String macAddress;
	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public Date getDateAction() {
		return dateAction;
	}
	
	public void setDateAction(Date dateAction) {
		this.dateAction = dateAction;
	}
	
	public String getAdmin() {
		return Admin;
	}
	
	public void setAdmin(String admin) {
		Admin = admin;
	}
	
	public String getMacAddress() {
		return macAddress;
	}
	
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	
	private static final long serialVersionUID = 1L;
	 

}
