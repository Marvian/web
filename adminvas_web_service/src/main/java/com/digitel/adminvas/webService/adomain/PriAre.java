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
@Table (name = "A_PRI_ARE")
public class PriAre implements Serializable {

	@Id
	@GeneratedValue(generator="SEQ_pri_are", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_pri_are", sequenceName = "SEQ_pri_are", allocationSize = 1)
	@Column(name = "par_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="par_fk_are")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Area area;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="par_fk_pri")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Privilege privilege;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}



	private static final long serialVersionUID = 1L;
}
