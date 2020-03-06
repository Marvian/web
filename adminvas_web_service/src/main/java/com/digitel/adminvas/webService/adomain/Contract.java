package com.digitel.adminvas.webService.adomain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "A_CONTRATO")
public class Contract implements Serializable {


	@Id
	@GeneratedValue(generator="SEQ_contrato", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_contrato", sequenceName = "SEQ_contrato", allocationSize = 1)
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="con_fk_tco")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ContracType fk_type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="con_fk_pro")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Provider fk_provider;
	
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

	public ContracType getFk_type() {
		return fk_type;
	}

	public void setFk_type(ContracType fk_type) {
		this.fk_type = fk_type;
	}

	public Provider getFk_provider() {
		return fk_provider;
	}

	public void setFk_provider(Provider fk_provider) {
		this.fk_provider = fk_provider;
	}

	private static final long serialVersionUID = 1L;
	
}
