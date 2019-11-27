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
@Table (name = "A_CONTRATO")
public class Contract implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_contrato")
	@Column(name = "con_id")
	private int id;
	
	@Column(name = "con_porcenaje_rev_sha_prov")
	private int percent;
	
	@Column(name = "con_fecha_solicitud")
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestDate;
	
	@Column(name = "con_fecha_firma")
	@Temporal(TemporalType.TIMESTAMP)
	private Date firmDate;
	
	@Column(name = "con_fecha_ult_cambio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastChangeDate;
	
	@Column(name = "con_fecha_caducidad")
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

	public int getPercent() {
		return percent;
	}
	
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	public Date getRequestDate() {
		return requestDate;
	}
	
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	public Date getFirmDate() {
		return firmDate;
	}
	
	public void setFirmDate(Date firmDate) {
		this.firmDate = firmDate;
	}
	
	public Date getLastChangeDate() {
		return lastChangeDate;
	}
	
	public void setLastChangeDate(Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
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
