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
@Table (name = "A_EJEM_CONTENIDO")
public class ContentExample implements Serializable {
	
	@Id
	@GeneratedValue(generator="SEQ_ejem_contenido", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_ejem_contenido",  sequenceName = "SEQ_ejem_contenido", allocationSize = 1)
	@Column(name = "add_id")
	private int id;
	
	@Column (name = "eco_ejemplo_mt")
	private String mt_example;
	
	@Column (name = "eco_ejemplo_mo")
	private String mo_example;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMt_example() {
		return mt_example;
	}

	public void setMt_example(String mt_example) {
		this.mt_example = mt_example;
	}

	public String getMo_example() {
		return mo_example;
	}

	public void setMo_example(String mo_example) {
		this.mo_example = mo_example;
	}

	private static final long serialVersionUID = 1L;

}
