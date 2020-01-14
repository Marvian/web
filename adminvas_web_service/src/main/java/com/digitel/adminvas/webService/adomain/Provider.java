package com.digitel.adminvas.webService.adomain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "A_PROVEEDOR")
public class Provider extends User implements Serializable {
		
	@Id
	@GeneratedValue(generator="SEQ_PROVEEDOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PROVEEDOR", sequenceName = "SEQ_PROVEEDOR", allocationSize = 1)
	@Column(name = "pro_id")
	private int id;
	
	@Column(name = "pro_sobrenombre")
	private String nickname;
	
	@Column(name = "pro_nombre")
	private String name;
	
	@Column(name = "pro_tipo_rif")
	private String typeRif;
	
	@Column(name = "pro_rif")
	private String rif;
	
	@Column(name = "pro_nit")
	private String nit;
	
	@Column(name = "pro_direccion")
	private String address;
	
	@Column(name = "pro_fecha_ult_login")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastloginDate;
	
	@Column(name = "pro_intentos_ingreso")
	private int intents;
	
	@Column(name = "pro_status")
	private String status;
	
	@Column(name = "pro_fk_are")
	private int fk_area;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTypeRif() {
		return typeRif;
	}
	
	public void setTypeRif(String typeRif) {
		this.typeRif = typeRif;
	}
	
	public String getRif() {
		return rif;
	}
	
	public void setRif(String rif) {
		this.rif = rif;
	}
	
	public String getNit() {
		return nit;
	}
	
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getLastloginDate() {
		return lastloginDate;
	}
	
	public void setLastloginDate(Date lastloginDate) {
		this.lastloginDate = lastloginDate;
	}
	
	public int getIntents() {
		return intents;
	}
	
	public void setIntents(int intents) {
		this.intents = intents;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFk_area() {
		return fk_area;
	}

	public void setFk_area(int fk_area) {
		this.fk_area = fk_area;
	}





	private static final long serialVersionUID = 1L;

}
