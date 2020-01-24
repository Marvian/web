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

@Entity
@Table (name = "A_CONFIG_SISTEMA")
public class ConfigSistem implements Serializable {

	@Id
	@GeneratedValue(generator="SEQ_config_sistema", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_config_sistema", sequenceName = "SEQ_config_sistema", allocationSize = 1)
	@Column(name = "csi_id")
	private int id;
	
	@Column(name = "csi_correo_empleado")
	private String email_employee;
	
	@Column(name = "csi_correo_proveedor_fecha")
	private String email_provider_date;
	
	@Column(name = "csi_correo_proveedor_procesado")
	private String email_provider_processed;
	
	@Column(name = "csi_fecha_limite")
	private Date limit_date;
		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail_employee() {
		return email_employee;
	}

	public void setEmail_employee(String email_employee) {
		this.email_employee = email_employee;
	}

	public String getEmail_provider_date() {
		return email_provider_date;
	}

	public void setEmail_provider_date(String email_provider_date) {
		this.email_provider_date = email_provider_date;
	}

	public String getEmail_provider_processed() {
		return email_provider_processed;
	}

	public void setEmail_provider_processed(String email_provider_processed) {
		this.email_provider_processed = email_provider_processed;
	}

	public Date getLimit_date() {
		return limit_date;
	}

	public void setLimit_date(Date limit_date) {
		this.limit_date = limit_date;
	}

	private static final long serialVersionUID = 1L;
	
}
