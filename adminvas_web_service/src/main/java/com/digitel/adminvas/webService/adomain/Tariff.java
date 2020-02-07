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
@Table (name = "A_TARIFA")
public class Tariff implements Serializable {

	@Id
	@GeneratedValue(generator="SEQ_tarifa", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_tarifa", sequenceName = "SEQ_tarifa", allocationSize = 1)
	@Column(name = "tar_id")
	private int id;
	
	@Column (name = "tar_fecha_prod")
	@Temporal(TemporalType.TIMESTAMP)
	private Date productionDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tar_fk_tba")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BasicTariff basicTariff;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tar_fk_tpr")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private PremiumTariff premiumTariff;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tar_fk_nco")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ShortCode shortCode;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public BasicTariff getBasicTariff() {
		return basicTariff;
	}

	public void setBasicTariff(BasicTariff basicTariff) {
		this.basicTariff = basicTariff;
	}

	public PremiumTariff getPremiumTariff() {
		return premiumTariff;
	}

	public void setPremiumTariff(PremiumTariff premiumTariff) {
		this.premiumTariff = premiumTariff;
	}

	public ShortCode getShortCode() {
		return shortCode;
	}

	public void setShortCode(ShortCode shortCode) {
		this.shortCode = shortCode;
	}

	private static final long serialVersionUID = 1L;
}
