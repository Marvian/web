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
@Table (name = "A_PRIVILEGIO")
public class Privilege implements Serializable {

	@Id
	@GeneratedValue(generator="SEQ_privilegio", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_privilegio", sequenceName = "SEQ_privilegio", allocationSize = 1)
	@Column(name = "pri_id")
	private int id;
	
	@Column(name = "pri_descripcion")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	private static final long serialVersionUID = 1L;
	
}
