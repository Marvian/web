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
@Table (name = "A_CONTRATO")
public class Contract implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_contrato")
	@SequenceGenerator(name = "SEQ_contrato", allocationSize = 1)
	@Column(name = "con_id")
	private int id;
	
	@Column(name = "con_numero")
	private String number;
	
	@Column(name = "con_porcentaje_rev_sha_prov")
	private int percent;
	
	@Column(name = "con_fecha_firma")
	@Temporal(TemporalType.TIMESTAMP)
	private Date firmDate;
	
	@Column(name = "con_fecha_cierre")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationDate;
	
	@Column(name = "con_fk_tco")
	private String fk_type;
	
	@Column(name = "con_fk_pro")
	private String fk_provider;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getPercent() {
		return percent;
	}
	
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	
	public Date getFirmDate() {
		return firmDate;
	}
	
	public void setFirmDate(Date firmDate) {
		this.firmDate = firmDate;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getFk_type() {
		return fk_type;
	}

	public void setFk_type(String fk_type) {
		this.fk_type = fk_type;
	}

	public String getFk_provider() {
		return fk_provider;
	}

	public void setFk_provider(String fk_provider) {
		this.fk_provider = fk_provider;
	}

	private static final long serialVersionUID = 1L;
	
}
