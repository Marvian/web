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
@Table (name = "A_ULTIMA_CONTRASEÑA")
public class LastPassword implements Serializable {
	
	@Id
	@GeneratedValue(generator="SEQ_ultima_cotraseña", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_ultima_cotraseña",  sequenceName = "SEQ_ultima_cotraseña", allocationSize = 1)
	@Column(name = "uco_id")
	private int id;
	
	@Column (name = "uco_contraseña")
	private String password;
	
	@Column(name = "uco_vigente")
	private boolean valid;
	
	@Column (name = "uco_fecha_caducidad")
	@Temporal(TemporalType.TIMESTAMP)
	private Date closingDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="uco_fk_pro")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Provider provider;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	private static final long serialVersionUID = 1L;

}
