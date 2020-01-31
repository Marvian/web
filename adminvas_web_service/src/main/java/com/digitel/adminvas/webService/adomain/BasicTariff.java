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
