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
@Table (name = "A_INTERFACE")
public class Interface implements Serializable {

	@Id
	@GeneratedValue(generator="SEQ_interface", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_interface", sequenceName = "SEQ_interface", allocationSize = 1)
	@Column(name = "int_id")
	private int id;
	
	@Column(name = "int_nombre")
	private String name;
	
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

	private static final long serialVersionUID = 1L;
	
}
