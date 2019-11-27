package com.digitel.adminvas.webService.adomain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "A_PROVEEDOR")
public class Provider extends User implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_provider")
	@Column(name = "pro_id")
	private int id;
	
	@Column(name = "pro_sobrenombre")
	private String name;
	
	@Column(name = "pro_tipo_rif")
	private char typeRif;
	
	@Column(name = "pro_rif")
	private String rif;
	
	@Column(name = "pro_nit")
	private String nit;
	
	@Column(name = "pro_direccion")
	private String address;
	
	@Column(name = "pro_fecha_ult_login")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastloginDate;
	
	@Column(name = "pro_intetos_ingreso")
	private int intents;
	
	@Column(name = "pro_status")
	private int status;
	
	private boolean valid;
	private Date validDate;
	private String[] interfaces;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public char getTypeRif() {
		return typeRif;
	}
	
	public void setTypeRif(char typeRif) {
		this.typeRif = typeRif;
	}
	
	public String getRif() {
		return rif;
	}
	
	public void setRif(String rif) {
		this.rif = rif;
	}
	
	public String getNit() {
		return nit;
	}
	
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getLastloginDate() {
		return lastloginDate;
	}
	
	public void setLastloginDate(Date lastloginDate) {
		this.lastloginDate = lastloginDate;
	}
	
	public int getIntents() {
		return intents;
	}
	
	public void setIntents(int intents) {
		this.intents = intents;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public String[] getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(String[] interfaces) {
		this.interfaces = interfaces;
	}
	
	private static final long serialVersionUID = 1L;

}
