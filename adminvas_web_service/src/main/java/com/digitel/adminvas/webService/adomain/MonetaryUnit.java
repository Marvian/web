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
@Table (name = "A_UNIDAD_MONETARIA")
public class MonetaryUnit implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_unidad_monetaria")
	@Column(name = "umo_id")
	private int id;
	
	@Column(name = "umo_nombre")
	private String name;
	
	@Column(name = "umo_notacion")
	private String notation;
	
	@Column(name = "umo_fecha_vigencia")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validDate;
	
	@Column(name = "umo_fecha_cierre")
	@Temporal(TemporalType.TIMESTAMP)
	private Date closingDate;
	
	@Column(name = "umo_vigente")
	private boolean valid;
	
	
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

	private static final long serialVersionUID = 1L;	
}
