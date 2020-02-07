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
@Table (name = "A_TIPO_CONTRATO")
public class ContracType implements Serializable {
	
	@Id
	@GeneratedValue(generator="SEQ_tipo_contrato", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_tipo_contrato",  sequenceName = "SEQ_tipo_contrato", allocationSize = 1)
	@Column(name = "tco_id")
	private int id;
	
	@Column (name = "tco_tipo")
	private String type;
	
	@Column(name = "tco_descripcion")
	private String description;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private static final long serialVersionUID = 1L;

}
