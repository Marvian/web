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
@Table (name = "A_CONTACTO")
public class ProviderContact implements Serializable {
	
	@Id
	@GeneratedValue(generator="SEQ_contacto_proveedor", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_contacto_proveedor", sequenceName = "SEQ_contacto_proveedor", allocationSize = 1)
	@Column(name = "cpr_id")
	private int id;
	
	@Column (name = "cpr_nombre")
	private String name;
	
	@Column (name = "cpr_apellido")
	private String lastname;
	
	@Column (name = "cpr_telefono")
	private String telephone;
	
	@Column (name = "cpr_correo")
	private String email;
	
	@Column (name = "cpr_nivel")
	private String level;
	
	@Column (name = "cpr_cargo")
	private String position;
	
	@Column (name = "cpr_descripcion")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cpr_fk_pro")
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
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}




	private static final long serialVersionUID = 1L;

}
