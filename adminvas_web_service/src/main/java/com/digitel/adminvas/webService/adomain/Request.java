package com.digitel.adminvas.webService.adomain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "A_Solicitud")
public class Request implements Serializable {
	
	@Id
	@GeneratedValue(generator="SEQ_solicitud", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_solicitud", sequenceName = "SEQ_solicitud", allocationSize = 1)
	@Column(name = "sol_id")
	private int id;
	
	@Column(name = "sol_status")
	private String status;
	
	@Column(name = "sol_fecha_solicitud")
	private Date dateRequest;
	
	@Column(name = "sol_tarifa")
	private int cost;
	
	@Column(name = "sol_aprovacion_finanza")
	private String admin_finance;
	
	@Column(name = "sol_aprovacion_seguridad")
	private String admin_segurity;
	
	@Column(name = "sol_aprovacion_prepago")
	private String admin_prepago;
	
	@Column(name = "sol_aprovacion_postpago")
	private String admin_postpago;
	
	@Column(name = "sol_aprovacion_vas")
	private String admin_vas;
	
	@Column(name = "sol_fk_nco")
	private int fk_shortCode;
	
	@Column(name = "sol_fk_tso")
	private int typeRequest;
	
	@Column(name = "sol_fk_pro")
	private int fk_provider;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



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



	public int getFk_shortCode() {
		return fk_shortCode;
	}



	public void setFk_shortCode(int fk_shortCode) {
		this.fk_shortCode = fk_shortCode;
	}



	public int getTypeRequest() {
		return typeRequest;
	}



	public void setTypeRequest(int typeRequest) {
		this.typeRequest = typeRequest;
	}



	public int getFk_provider() {
		return fk_provider;
	}



	public void setFk_provider(int fk_provider) {
		this.fk_provider = fk_provider;
	}



	private static final long serialVersionUID = 1L;	

}
