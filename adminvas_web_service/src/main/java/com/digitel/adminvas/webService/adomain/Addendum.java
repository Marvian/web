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
@Table (name = "A_ADDENDUM")
public class Addendum implements Serializable {
	
	@Id
	@GeneratedValue(generator="SEQ_addendum", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_addendum",  sequenceName = "SEQ_addendum", allocationSize = 1)
	@Column(name = "add_id")
	private int id;
	
	@Column (name = "add_fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column (name = "add_porcentajes_rev_sha_prov")
	private int percent;
	
	@Column (name = "add_tipo")
	private String type;
	
	@Column (name = "add_descripcion")
	private String description;
	
	@Column (name = "add_cantidad_mt_por_mo")
	private int MTXMO;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public int getPercent() {
		return percent;
	}
	
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMTXMO() {
		return MTXMO;
	}

	public void setMTXMO(int mTXMO) {
		MTXMO = mTXMO;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	private static final long serialVersionUID = 1L;

}
