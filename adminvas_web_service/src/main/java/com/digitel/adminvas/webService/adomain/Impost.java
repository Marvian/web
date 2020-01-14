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
@Table (name = "A_IMPUESTO")
public class Impost implements Serializable{
	
	@Id
	@GeneratedValue(generator="SEQ_impuesto", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_impuesto", sequenceName = "SEQ_impuesto", allocationSize = 1)
	@Column(name = "imp_id")
	private int id;
	
	@Column(name = "imp_nombre")
	private String name;
	
	@Column(name = "imp_porcentaje")
	private int percent;
	
	@Column(name = "imp_fecha_vigencia")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validDate;
	
	@Column(name = "imp_fecha_cierre")
	@Temporal(TemporalType.TIMESTAMP)
	private Date closingDate;
	
	@Column(name = "imp_vigente")
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
	
	private static final long serialVersionUID = 1L;

}
