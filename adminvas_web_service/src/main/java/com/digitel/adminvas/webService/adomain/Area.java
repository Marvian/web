package com.digitel.adminvas.webService.adomain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "A_AREA")
public class Area implements Serializable {

	@Id
	@GeneratedValue(generator="SEQ_area", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_area", sequenceName = "SEQ_area", allocationSize = 1)
	@Column(name = "are_id")
	private int id;
	
	@Column(name = "are_nombre")
	private String name;
	
	@Column(name = "are_correo")
	private String email;
	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	private static final long serialVersionUID = 1L;
	
	

}
