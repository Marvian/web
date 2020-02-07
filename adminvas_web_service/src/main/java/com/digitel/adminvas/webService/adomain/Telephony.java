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
@Table (name = "A_TELEFONIA")
public class Telephony implements Serializable {
	
	@Id
	@GeneratedValue(generator="SEQ_telefonia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_telefonia",  sequenceName = "SEQ_telefonia", allocationSize = 1)
	@Column(name = "tel_id")
	private int id;
	
	@Column (name = "tel_tipo")
	private String type;
	
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

	private static final long serialVersionUID = 1L;

}
