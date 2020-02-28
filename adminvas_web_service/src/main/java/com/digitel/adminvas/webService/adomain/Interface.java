package com.digitel.adminvas.webService.adomain;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="int_fk_pro")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Provider provider;
	
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

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}



	private static final long serialVersionUID = 1L;
	
}
