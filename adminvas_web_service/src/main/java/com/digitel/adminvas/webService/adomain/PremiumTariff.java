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
@Table (name = "A_TARIFA_BASE")
public class PremiumTariff implements Serializable {

	@Id
	@GeneratedValue(generator="SEQ_tarifa_base", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_tarifa_base", sequenceName = "SEQ_tarifa_base", allocationSize = 1)
	@Column(name = "tpr_id")
	private int id;
	
	@Column(name = "tpr_tipo_mensaje")
	private String type_message;
	
	@Column(name = "tpr_monto")
	private float amount;
		
	@Column (name = "tpr_fecha_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name = "tpr_fecha_fin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date closingDate;
	
	@Column(name = "tpr_vigente")
	private boolean valid;
	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType_message() {
		return type_message;
	}

	public void setType_message(String type_message) {
		this.type_message = type_message;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
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

	private static final long serialVersionUID = 1L;
}
