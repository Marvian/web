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
@Table (name = "A_TARIFA_BASE")
public class BasicTariff implements Serializable {

	@Id
	@GeneratedValue(generator="SEQ_tarifa_base", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_tarifa_base", sequenceName = "SEQ_tarifa_base", allocationSize = 1)
	@Column(name = "tba_id")
	private int id;
	
	@Column(name = "tba_monto")
	private float amount;
	
	@Column(name = "tba_tipo_trafico")
	private String trafic;
	
	@Column (name = "tba_fecha_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name = "tba_fecha_fin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date closingDate;
	
	@Column(name = "tba_vigente")
	private boolean valid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tba_fk_tel")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Telephony telephony;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
		
	public String getTrafic() {
		return trafic;
	}

	public void setTrafic(String trafic) {
		this.trafic = trafic;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	
	public Telephony getTelephony() {
		return telephony;
	}

	public void setTelephony(Telephony telephony) {
		this.telephony = telephony;
	}



	private static final long serialVersionUID = 1L;
}
