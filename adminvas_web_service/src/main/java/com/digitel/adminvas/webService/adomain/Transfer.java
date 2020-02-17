package com.digitel.adminvas.webService.adomain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "A_TRASPASO")
public class Transfer implements Serializable {
	
	@Id
	@GeneratedValue(generator="SEQ_traspaso", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_traspaso", sequenceName = "SEQ_traspaso", allocationSize = 1)
	@Column(name = "tra_id")
	private int id;
	
	@Column(name = "sol_fecha_solicitud")
	private Date dateRequest;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateRequest() {
		return dateRequest;
	}

	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}

	private static final long serialVersionUID = 1L;	

}
