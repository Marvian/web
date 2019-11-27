package com.digitel.adminvas.webService.adomain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "A_TARIFA_BASE")
public class BasicTariff implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_tarifa_base")
	@Column(name = "tba_id")
	private int id;
	
	@Column(name = "tba_monto")
	private float amount;
	
	@Column(name = "tba_tipo_trafico")
	private String trafic;
	
	@Column(name = "tba_vigente")
	private boolean valid;
	
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

	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	private static final long serialVersionUID = 1L;
}
