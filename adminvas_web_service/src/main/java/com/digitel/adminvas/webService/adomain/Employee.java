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
@Table (name = "A_EMPLEADO")
public class Employee extends User implements Serializable{
	
	@Id
	@GeneratedValue(generator="SEQ_empleado", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_empleado", sequenceName = "SEQ_empleado", allocationSize = 1)
	@Column(name = "emp_id")
	private int id;
	
	@Column(name = "emp_nombre")
	private String name;
	
	@Column(name = "emp_cargo")
	private String  position;
	
	@Column(name = "emp_aprobador")
	private String approver;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="emp_fk_are")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Area area;
	
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
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	private static final long serialVersionUID = 1L;
	

}
