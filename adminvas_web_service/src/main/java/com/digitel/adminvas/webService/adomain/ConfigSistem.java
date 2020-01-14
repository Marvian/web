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
@Table (name = "A_CONFIG_SISTEMA")
public class ConfigSistem implements Serializable {

	@Id
	@GeneratedValue(generator="SEQ_config_sistema", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_config_sistema", sequenceName = "SEQ_config_sistema", allocationSize = 1)
	@Column(name = "csi_id")
	private int id;
	
	@Column(name = "csi_caracteristica")
	private String characteristic;
	
	@Column(name = "csi_valor")
	private String value;
		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCharacteristic() {
		return characteristic;
	}
	
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	private static final long serialVersionUID = 1L;
	
}
